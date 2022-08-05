package com.nsdciot.novel.controller;

import com.nsdciot.novel.core.bean.UserDetails;
import com.nsdciot.novel.entity.Book;
import com.nsdciot.novel.service.AuthorService;
import com.nsdciot.novel.service.BookContentService;
import com.nsdciot.novel.service.BookService;
import com.nsdciot.novel.service.NewsService;
import com.nsdciot.novel.service.UserService;
import com.nsdciot.novel.vo.BookCommentVO;
import com.nsdciot.novel.vo.BookSettingVO;
import com.nsdciot.novel.entity.BookContent;
import com.nsdciot.novel.entity.BookIndex;
import com.nsdciot.novel.entity.News;
import io.github.xxyopen.model.page.PageBean;
import io.github.xxyopen.model.resp.RestResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11797
 */
@Slf4j
@RestController
@RequestMapping("wxPage")
public class WxPageController extends BaseController  {


    @Autowired
    private BookService bookService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserService userService;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private Map<String, BookContentService> bookContentServiceMap;


    /**
     * 首页
     */
    @SneakyThrows
    @GetMapping(path = {"/", "/index", "/index.html"})
    public RestResult<Map> index() {
        Map dataMap = new HashMap();
        //加载小说首页小说基本信息线程
        CompletableFuture<Map<Byte, List<BookSettingVO>>> bookCompletableFuture = CompletableFuture.supplyAsync(bookService::listBookSettingVO, threadPoolExecutor);
        //加载首页新闻线程
        CompletableFuture<List<News>> newsCompletableFuture = CompletableFuture.supplyAsync(newsService::listIndexNews, threadPoolExecutor);
        dataMap.put("bookMap", bookCompletableFuture.get());
        dataMap.put("newsList", newsCompletableFuture.get());
        return RestResult.ok(dataMap);
    }

    /**
     * 首次访问小说的内容页
     */
    @SneakyThrows
    @GetMapping("/firstVisitBook/{bookId}")
    public RestResult<Map> bookContent(@PathVariable("bookId") Long bookId, HttpServletRequest request) {
        Map dataMap = new HashMap();

         AtomicReference<Long> bookIndexId = new AtomicReference<>(0L);

        //加载小说基本信息线程
        CompletableFuture<Book> bookCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //查询书籍
            Book book = bookService.queryBookDetail(bookId);
            log.debug("加载小说基本信息线程结束");
            return book;
        }, threadPoolExecutor);
        //加载小说首章信息线程，该线程在加载小说基本信息线程执行完毕后才执行
        CompletableFuture<Long> firstBookIndexIdCompletableFuture = bookCompletableFuture.thenApplyAsync((book) -> {
            if (book.getLastIndexId() != null) {
                //查询首章目录ID
                Long firstBookIndexId = bookService.queryFirstBookIndexId(bookId);
                log.debug("加载小说基本信息线程结束");
                bookIndexId.set(firstBookIndexId);
                return firstBookIndexId;
            }
            return null;
        }, threadPoolExecutor);
        //加载小说章节信息线程
        CompletableFuture<BookIndex> bookIndexCompletableFuture = firstBookIndexIdCompletableFuture.thenApplyAsync((firstBookIndexId) -> {
            //查询目录
            BookIndex bookIndex = bookService.queryBookIndex(firstBookIndexId);
            log.debug("加载小说章节信息线程结束");
            return bookIndex;
        }, threadPoolExecutor);

        //加载小说上一章节信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Long> preBookIndexIdCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询上一章节目录ID
            Long preBookIndexId = bookService.queryPreBookIndexId(bookId, bookIndex.getIndexNum());
            log.debug("加载小说上一章节信息线程结束");
            return preBookIndexId;
        }, threadPoolExecutor);

        //加载小说下一章节信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Long> nextBookIndexIdCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询下一章目录ID
            Long nextBookIndexId = bookService.queryNextBookIndexId(bookId, bookIndex.getIndexNum());
            log.debug("加载小说下一章节信息线程结束");
            return nextBookIndexId;
        }, threadPoolExecutor);

        //加载小说内容信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<BookContent> bookContentCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询内容
            BookContent bookContent = bookContentServiceMap.get(bookIndex.getStorageType()).queryBookContent(bookId,
                bookIndexId.get());
            log.debug("加载小说内容信息线程结束");
            return bookContent;
        }, threadPoolExecutor);


        //判断用户是否需要购买线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Boolean> needBuyCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //判断该目录是否收费
            if (bookIndex.getIsVip() != null && bookIndex.getIsVip() == 1) {
                //收费
                UserDetails user = getUserDetails(request);
                if (user == null) {
                    //未登录，需要购买
                    return true;
                }
                //判断用户是否购买过该目录
                boolean isBuy = userService.queryIsBuyBookIndex(user.getId(), bookIndexId.get());
                if (!isBuy) {
                    //没有购买过，需要购买
                    return true;
                }
            }

            log.debug("判断用户是否需要购买线程结束");
            return false;

        }, threadPoolExecutor);


        dataMap.put("book", bookCompletableFuture.get());
        dataMap.put("bookIndex", bookIndexCompletableFuture.get());
        dataMap.put("preBookIndexId", preBookIndexIdCompletableFuture.get());
        dataMap.put("nextBookIndexId", nextBookIndexIdCompletableFuture.get());
        dataMap.put("bookContent", bookContentCompletableFuture.get());
        dataMap.put("needBuy", needBuyCompletableFuture.get());

        return RestResult.ok(dataMap);
    }



    /**
     * 详情页
     */
    @SneakyThrows
    @GetMapping("/book/{bookId}")
    public RestResult<Map> bookDetail(@PathVariable("bookId") Long bookId, Model model) {
        //加载小说基本信息线程
        CompletableFuture<Book> bookCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //查询书籍
            Book book = bookService.queryBookDetail(bookId);
            log.debug("加载小说基本信息线程结束");
            return book;
        }, threadPoolExecutor);
        //加载小说评论列表线程
        CompletableFuture<PageBean<BookCommentVO>> bookCommentPageBeanCompletableFuture = CompletableFuture.supplyAsync(() -> {
            PageBean<BookCommentVO> bookCommentVOPageBean = bookService.listCommentByPage(null, bookId, 1, 5);
            log.debug("加载小说评论列表线程结束");
            return bookCommentVOPageBean;
        }, threadPoolExecutor);
        //加载小说首章信息线程，该线程在加载小说基本信息线程执行完毕后才执行
        CompletableFuture<Long> firstBookIndexIdCompletableFuture = bookCompletableFuture.thenApplyAsync((book) -> {
            if (book.getLastIndexId() != null) {
                //查询首章目录ID
                Long firstBookIndexId = bookService.queryFirstBookIndexId(bookId);
                log.debug("加载小说基本信息线程结束");
                return firstBookIndexId;
            }
            return null;
        }, threadPoolExecutor);
        //加载随机推荐小说线程，该线程在加载小说基本信息线程执行完毕后才执行
        CompletableFuture<List<Book>> recBookCompletableFuture = bookCompletableFuture.thenApplyAsync((book) -> {
            List<Book> books = bookService.listRecBookByCatId(book.getCatId());
            log.debug("加载随机推荐小说线程结束");
            return books;
        }, threadPoolExecutor);

        Map dataMap = new HashMap();

        dataMap.put("book", bookCompletableFuture.get());
        dataMap.put("firstBookIndexId", firstBookIndexIdCompletableFuture.get());
        dataMap.put("recBooks", recBookCompletableFuture.get());
        dataMap.put("bookCommentPageBean", bookCommentPageBeanCompletableFuture.get());

        return RestResult.ok(dataMap);
    }

    /**
     * 目录页
     */
    @SneakyThrows
    @GetMapping("/book/catalogue/{bookId}")
    public RestResult<Map> catalogue(@PathVariable("bookId") Long bookId) {
        Map dataMap = new HashMap();

        Book book = bookService.queryBookDetail(bookId);
        dataMap.put("book", book);
        List<BookIndex> bookIndexList = bookService.queryIndexList(bookId, null, 1, null);

        dataMap.put("bookIndexList", bookIndexList);
        dataMap.put("bookIndexCount", bookIndexList.size());
        return RestResult.ok(dataMap);
    }

    /**
     * 内容页
     */
    @SneakyThrows
    @GetMapping("/book/{bookId}/{bookIndexId}")
    public RestResult<Map> bookContent(@PathVariable("bookId") Long bookId, @PathVariable("bookIndexId") Long bookIndexId, HttpServletRequest request) {
        Map dataMap = new HashMap();

        //加载小说基本信息线程
        CompletableFuture<Book> bookCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //查询书籍
            Book book = bookService.queryBookDetail(bookId);
            log.debug("加载小说基本信息线程结束");
            return book;
        }, threadPoolExecutor);

        //加载小说章节信息线程
        CompletableFuture<BookIndex> bookIndexCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //查询目录
            BookIndex bookIndex = bookService.queryBookIndex(bookIndexId);
            log.debug("加载小说章节信息线程结束");
            return bookIndex;
        }, threadPoolExecutor);

        //加载小说上一章节信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Long> preBookIndexIdCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询上一章节目录ID
            Long preBookIndexId = bookService.queryPreBookIndexId(bookId, bookIndex.getIndexNum());
            log.debug("加载小说上一章节信息线程结束");
            return preBookIndexId;
        }, threadPoolExecutor);

        //加载小说下一章节信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Long> nextBookIndexIdCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询下一章目录ID
            Long nextBookIndexId = bookService.queryNextBookIndexId(bookId, bookIndex.getIndexNum());
            log.debug("加载小说下一章节信息线程结束");
            return nextBookIndexId;
        }, threadPoolExecutor);

        //加载小说内容信息线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<BookContent> bookContentCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //查询内容
            BookContent bookContent = bookContentServiceMap.get(bookIndex.getStorageType()).queryBookContent(bookId, bookIndexId);
            log.debug("加载小说内容信息线程结束");
            return bookContent;
        }, threadPoolExecutor);


        //判断用户是否需要购买线程，该线程在加载小说章节信息线程执行完毕后才执行
        CompletableFuture<Boolean> needBuyCompletableFuture = bookIndexCompletableFuture.thenApplyAsync((bookIndex) -> {
            //判断该目录是否收费
            if (bookIndex.getIsVip() != null && bookIndex.getIsVip() == 1) {
                //收费
                UserDetails user = getUserDetails(request);
                if (user == null) {
                    //未登录，需要购买
                    return true;
                }
                //判断用户是否购买过该目录
                boolean isBuy = userService.queryIsBuyBookIndex(user.getId(), bookIndexId);
                if (!isBuy) {
                    //没有购买过，需要购买
                    return true;
                }
            }

            log.debug("判断用户是否需要购买线程结束");
            return false;

        }, threadPoolExecutor);


        dataMap.put("book", bookCompletableFuture.get());
        dataMap.put("bookIndex", bookIndexCompletableFuture.get());
        dataMap.put("preBookIndexId", preBookIndexIdCompletableFuture.get());
        dataMap.put("nextBookIndexId", nextBookIndexIdCompletableFuture.get());
        dataMap.put("bookContent", bookContentCompletableFuture.get());
        dataMap.put("needBuy", needBuyCompletableFuture.get());

        return RestResult.ok(dataMap);
    }

    /**
     * 评论页面
     */
    @GetMapping("/book/comment-{bookId}")
    public RestResult<Map> commentList(@PathVariable("bookId") Long bookId, Model model) {
        Map dataMap = new HashMap();

        //查询书籍
        Book book = bookService.queryBookDetail(bookId);
        dataMap.put("book", book);
        return RestResult.ok(dataMap);
    }

    /**
     * 新闻内容页面
     */
    @GetMapping("/about/newsInfo-{newsId}")
    public RestResult<Map> newsInfo(@PathVariable("newsId") Long newsId, Model model) {
        Map dataMap = new HashMap();
        //查询新闻
        News news = newsService.queryNewsInfo(newsId);
        dataMap.put("news", news);
        return RestResult.ok(dataMap);
    }



}
