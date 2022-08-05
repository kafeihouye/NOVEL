package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface BookMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(BookDynamicSqlSupport.id, BookDynamicSqlSupport.workDirection, BookDynamicSqlSupport.catId, BookDynamicSqlSupport.catName, BookDynamicSqlSupport.picUrl, BookDynamicSqlSupport.bookName, BookDynamicSqlSupport.authorId, BookDynamicSqlSupport.authorName, BookDynamicSqlSupport.bookDesc, BookDynamicSqlSupport.score, BookDynamicSqlSupport.bookStatus, BookDynamicSqlSupport.visitCount, BookDynamicSqlSupport.wordCount, BookDynamicSqlSupport.commentCount, BookDynamicSqlSupport.yesterdayBuy, BookDynamicSqlSupport.lastIndexId, BookDynamicSqlSupport.lastIndexName, BookDynamicSqlSupport.lastIndexUpdateTime, BookDynamicSqlSupport.isVip, BookDynamicSqlSupport.status, BookDynamicSqlSupport.updateTime, BookDynamicSqlSupport.createTime, BookDynamicSqlSupport.crawlSourceId, BookDynamicSqlSupport.crawlBookId, BookDynamicSqlSupport.crawlLastTime, BookDynamicSqlSupport.crawlIsStop);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<Book> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Book> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("BookResult")
    Optional<Book> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "BookResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "work_direction", property = "workDirection", jdbcType = JdbcType.TINYINT),
            @Result(column = "cat_id", property = "catId", jdbcType = JdbcType.INTEGER),
            @Result(column = "cat_name", property = "catName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_name", property = "bookName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "author_id", property = "authorId", jdbcType = JdbcType.BIGINT),
            @Result(column = "author_name", property = "authorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_desc", property = "bookDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "score", property = "score", jdbcType = JdbcType.REAL),
            @Result(column = "book_status", property = "bookStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "visit_count", property = "visitCount", jdbcType = JdbcType.BIGINT),
            @Result(column = "word_count", property = "wordCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "comment_count", property = "commentCount", jdbcType = JdbcType.INTEGER),
            @Result(column="yesterday_buy", property="yesterdayBuy", jdbcType=JdbcType.INTEGER),
            @Result(column = "last_index_id", property = "lastIndexId", jdbcType = JdbcType.BIGINT),
            @Result(column = "last_index_name", property = "lastIndexName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_index_update_time", property = "lastIndexUpdateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "is_vip", property = "isVip", jdbcType = JdbcType.TINYINT),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "crawl_source_id", property = "crawlSourceId", jdbcType = JdbcType.INTEGER),
            @Result(column = "crawl_book_id", property = "crawlBookId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "crawl_last_time", property = "crawlLastTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "crawl_is_stop", property = "crawlIsStop", jdbcType = JdbcType.TINYINT)
    })
    List<Book> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(BookDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Book record) {
        return MyBatis3Utils.insert(this::insert, record, BookDynamicSqlSupport.book, c ->
                c.map(BookDynamicSqlSupport.id).toProperty("id")
                        .map(BookDynamicSqlSupport.workDirection).toProperty("workDirection")
                        .map(BookDynamicSqlSupport.catId).toProperty("catId")
                        .map(BookDynamicSqlSupport.catName).toProperty("catName")
                        .map(BookDynamicSqlSupport.picUrl).toProperty("picUrl")
                        .map(BookDynamicSqlSupport.bookName).toProperty("bookName")
                        .map(BookDynamicSqlSupport.authorId).toProperty("authorId")
                        .map(BookDynamicSqlSupport.authorName).toProperty("authorName")
                        .map(BookDynamicSqlSupport.bookDesc).toProperty("bookDesc")
                        .map(BookDynamicSqlSupport.score).toProperty("score")
                        .map(BookDynamicSqlSupport.bookStatus).toProperty("bookStatus")
                        .map(BookDynamicSqlSupport.visitCount).toProperty("visitCount")
                        .map(BookDynamicSqlSupport.wordCount).toProperty("wordCount")
                        .map(BookDynamicSqlSupport.commentCount).toProperty("commentCount")
                        .map(BookDynamicSqlSupport.yesterdayBuy).toProperty("yesterdayBuy")
                        .map(BookDynamicSqlSupport.lastIndexId).toProperty("lastIndexId")
                        .map(BookDynamicSqlSupport.lastIndexName).toProperty("lastIndexName")
                        .map(BookDynamicSqlSupport.lastIndexUpdateTime).toProperty("lastIndexUpdateTime")
                        .map(BookDynamicSqlSupport.isVip).toProperty("isVip")
                        .map(BookDynamicSqlSupport.status).toProperty("status")
                        .map(BookDynamicSqlSupport.updateTime).toProperty("updateTime")
                        .map(BookDynamicSqlSupport.createTime).toProperty("createTime")
                        .map(BookDynamicSqlSupport.crawlSourceId).toProperty("crawlSourceId")
                        .map(BookDynamicSqlSupport.crawlBookId).toProperty("crawlBookId")
                        .map(BookDynamicSqlSupport.crawlLastTime).toProperty("crawlLastTime")
                        .map(BookDynamicSqlSupport.crawlIsStop).toProperty("crawlIsStop")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Book> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, BookDynamicSqlSupport.book, c ->
                c.map(BookDynamicSqlSupport.id).toProperty("id")
                        .map(BookDynamicSqlSupport.workDirection).toProperty("workDirection")
                        .map(BookDynamicSqlSupport.catId).toProperty("catId")
                        .map(BookDynamicSqlSupport.catName).toProperty("catName")
                        .map(BookDynamicSqlSupport.picUrl).toProperty("picUrl")
                        .map(BookDynamicSqlSupport.bookName).toProperty("bookName")
                        .map(BookDynamicSqlSupport.authorId).toProperty("authorId")
                        .map(BookDynamicSqlSupport.authorName).toProperty("authorName")
                        .map(BookDynamicSqlSupport.bookDesc).toProperty("bookDesc")
                        .map(BookDynamicSqlSupport.score).toProperty("score")
                        .map(BookDynamicSqlSupport.bookStatus).toProperty("bookStatus")
                        .map(BookDynamicSqlSupport.visitCount).toProperty("visitCount")
                        .map(BookDynamicSqlSupport.wordCount).toProperty("wordCount")
                        .map(BookDynamicSqlSupport.commentCount).toProperty("commentCount")
                        .map(BookDynamicSqlSupport.yesterdayBuy).toProperty("yesterdayBuy")
                        .map(BookDynamicSqlSupport.lastIndexId).toProperty("lastIndexId")
                        .map(BookDynamicSqlSupport.lastIndexName).toProperty("lastIndexName")
                        .map(BookDynamicSqlSupport.lastIndexUpdateTime).toProperty("lastIndexUpdateTime")
                        .map(BookDynamicSqlSupport.isVip).toProperty("isVip")
                        .map(BookDynamicSqlSupport.status).toProperty("status")
                        .map(BookDynamicSqlSupport.updateTime).toProperty("updateTime")
                        .map(BookDynamicSqlSupport.createTime).toProperty("createTime")
                        .map(BookDynamicSqlSupport.crawlSourceId).toProperty("crawlSourceId")
                        .map(BookDynamicSqlSupport.crawlBookId).toProperty("crawlBookId")
                        .map(BookDynamicSqlSupport.crawlLastTime).toProperty("crawlLastTime")
                        .map(BookDynamicSqlSupport.crawlIsStop).toProperty("crawlIsStop")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Book record) {
        return MyBatis3Utils.insert(this::insert, record, BookDynamicSqlSupport.book, c ->
                c.map(BookDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                        .map(BookDynamicSqlSupport.workDirection).toPropertyWhenPresent("workDirection", record::getWorkDirection)
                        .map(BookDynamicSqlSupport.catId).toPropertyWhenPresent("catId", record::getCatId)
                        .map(BookDynamicSqlSupport.catName).toPropertyWhenPresent("catName", record::getCatName)
                        .map(BookDynamicSqlSupport.picUrl).toPropertyWhenPresent("picUrl", record::getPicUrl)
                        .map(BookDynamicSqlSupport.bookName).toPropertyWhenPresent("bookName", record::getBookName)
                        .map(BookDynamicSqlSupport.authorId).toPropertyWhenPresent("authorId", record::getAuthorId)
                        .map(BookDynamicSqlSupport.authorName).toPropertyWhenPresent("authorName", record::getAuthorName)
                        .map(BookDynamicSqlSupport.bookDesc).toPropertyWhenPresent("bookDesc", record::getBookDesc)
                        .map(BookDynamicSqlSupport.score).toPropertyWhenPresent("score", record::getScore)
                        .map(BookDynamicSqlSupport.bookStatus).toPropertyWhenPresent("bookStatus", record::getBookStatus)
                        .map(BookDynamicSqlSupport.visitCount).toPropertyWhenPresent("visitCount", record::getVisitCount)
                        .map(BookDynamicSqlSupport.wordCount).toPropertyWhenPresent("wordCount", record::getWordCount)
                        .map(BookDynamicSqlSupport.commentCount).toPropertyWhenPresent("commentCount", record::getCommentCount)
                        .map(BookDynamicSqlSupport.yesterdayBuy).toPropertyWhenPresent("yesterdayBuy", record::getYesterdayBuy)
                        .map(BookDynamicSqlSupport.lastIndexId).toPropertyWhenPresent("lastIndexId", record::getLastIndexId)
                        .map(BookDynamicSqlSupport.lastIndexName).toPropertyWhenPresent("lastIndexName", record::getLastIndexName)
                        .map(BookDynamicSqlSupport.lastIndexUpdateTime).toPropertyWhenPresent("lastIndexUpdateTime", record::getLastIndexUpdateTime)
                        .map(BookDynamicSqlSupport.isVip).toPropertyWhenPresent("isVip", record::getIsVip)
                        .map(BookDynamicSqlSupport.status).toPropertyWhenPresent("status", record::getStatus)
                        .map(BookDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                        .map(BookDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(BookDynamicSqlSupport.crawlSourceId).toPropertyWhenPresent("crawlSourceId", record::getCrawlSourceId)
                        .map(BookDynamicSqlSupport.crawlBookId).toPropertyWhenPresent("crawlBookId", record::getCrawlBookId)
                        .map(BookDynamicSqlSupport.crawlLastTime).toPropertyWhenPresent("crawlLastTime", record::getCrawlLastTime)
                        .map(BookDynamicSqlSupport.crawlIsStop).toPropertyWhenPresent("crawlIsStop", record::getCrawlIsStop)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Book> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Book> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Book> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Book> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(BookDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, BookDynamicSqlSupport.book, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Book record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
                .set(BookDynamicSqlSupport.catId).equalTo(record::getCatId)
                .set(BookDynamicSqlSupport.catName).equalTo(record::getCatName)
                .set(BookDynamicSqlSupport.picUrl).equalTo(record::getPicUrl)
                .set(BookDynamicSqlSupport.bookName).equalTo(record::getBookName)
                .set(BookDynamicSqlSupport.authorId).equalTo(record::getAuthorId)
                .set(BookDynamicSqlSupport.authorName).equalTo(record::getAuthorName)
                .set(BookDynamicSqlSupport.bookDesc).equalTo(record::getBookDesc)
                .set(BookDynamicSqlSupport.score).equalTo(record::getScore)
                .set(BookDynamicSqlSupport.bookStatus).equalTo(record::getBookStatus)
                .set(BookDynamicSqlSupport.visitCount).equalTo(record::getVisitCount)
                .set(BookDynamicSqlSupport.wordCount).equalTo(record::getWordCount)
                .set(BookDynamicSqlSupport.commentCount).equalTo(record::getCommentCount)
                .set(BookDynamicSqlSupport.yesterdayBuy).equalTo(record::getYesterdayBuy)
                .set(BookDynamicSqlSupport.lastIndexId).equalTo(record::getLastIndexId)
                .set(BookDynamicSqlSupport.lastIndexName).equalTo(record::getLastIndexName)
                .set(BookDynamicSqlSupport.lastIndexUpdateTime).equalTo(record::getLastIndexUpdateTime)
                .set(BookDynamicSqlSupport.isVip).equalTo(record::getIsVip)
                .set(BookDynamicSqlSupport.status).equalTo(record::getStatus)
                .set(BookDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(BookDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookDynamicSqlSupport.crawlSourceId).equalTo(record::getCrawlSourceId)
                .set(BookDynamicSqlSupport.crawlBookId).equalTo(record::getCrawlBookId)
                .set(BookDynamicSqlSupport.crawlLastTime).equalTo(record::getCrawlLastTime)
                .set(BookDynamicSqlSupport.crawlIsStop).equalTo(record::getCrawlIsStop);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Book record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(BookDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
                .set(BookDynamicSqlSupport.catName).equalToWhenPresent(record::getCatName)
                .set(BookDynamicSqlSupport.picUrl).equalToWhenPresent(record::getPicUrl)
                .set(BookDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                .set(BookDynamicSqlSupport.authorId).equalToWhenPresent(record::getAuthorId)
                .set(BookDynamicSqlSupport.authorName).equalToWhenPresent(record::getAuthorName)
                .set(BookDynamicSqlSupport.bookDesc).equalToWhenPresent(record::getBookDesc)
                .set(BookDynamicSqlSupport.score).equalToWhenPresent(record::getScore)
                .set(BookDynamicSqlSupport.bookStatus).equalToWhenPresent(record::getBookStatus)
                .set(BookDynamicSqlSupport.visitCount).equalToWhenPresent(record::getVisitCount)
                .set(BookDynamicSqlSupport.wordCount).equalToWhenPresent(record::getWordCount)
                .set(BookDynamicSqlSupport.commentCount).equalToWhenPresent(record::getCommentCount)
                .set(BookDynamicSqlSupport.yesterdayBuy).equalToWhenPresent(record::getYesterdayBuy)
                .set(BookDynamicSqlSupport.lastIndexId).equalToWhenPresent(record::getLastIndexId)
                .set(BookDynamicSqlSupport.lastIndexName).equalToWhenPresent(record::getLastIndexName)
                .set(BookDynamicSqlSupport.lastIndexUpdateTime).equalToWhenPresent(record::getLastIndexUpdateTime)
                .set(BookDynamicSqlSupport.isVip).equalToWhenPresent(record::getIsVip)
                .set(BookDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                .set(BookDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(BookDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookDynamicSqlSupport.crawlSourceId).equalToWhenPresent(record::getCrawlSourceId)
                .set(BookDynamicSqlSupport.crawlBookId).equalToWhenPresent(record::getCrawlBookId)
                .set(BookDynamicSqlSupport.crawlLastTime).equalToWhenPresent(record::getCrawlLastTime)
                .set(BookDynamicSqlSupport.crawlIsStop).equalToWhenPresent(record::getCrawlIsStop);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Book record) {
        return update(c ->
                c.set(BookDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
                        .set(BookDynamicSqlSupport.catId).equalTo(record::getCatId)
                        .set(BookDynamicSqlSupport.catName).equalTo(record::getCatName)
                        .set(BookDynamicSqlSupport.picUrl).equalTo(record::getPicUrl)
                        .set(BookDynamicSqlSupport.bookName).equalTo(record::getBookName)
                        .set(BookDynamicSqlSupport.authorId).equalTo(record::getAuthorId)
                        .set(BookDynamicSqlSupport.authorName).equalTo(record::getAuthorName)
                        .set(BookDynamicSqlSupport.bookDesc).equalTo(record::getBookDesc)
                        .set(BookDynamicSqlSupport.score).equalTo(record::getScore)
                        .set(BookDynamicSqlSupport.bookStatus).equalTo(record::getBookStatus)
                        .set(BookDynamicSqlSupport.visitCount).equalTo(record::getVisitCount)
                        .set(BookDynamicSqlSupport.wordCount).equalTo(record::getWordCount)
                        .set(BookDynamicSqlSupport.commentCount).equalTo(record::getCommentCount)
                        .set(BookDynamicSqlSupport.yesterdayBuy).equalTo(record::getYesterdayBuy)
                        .set(BookDynamicSqlSupport.lastIndexId).equalTo(record::getLastIndexId)
                        .set(BookDynamicSqlSupport.lastIndexName).equalTo(record::getLastIndexName)
                        .set(BookDynamicSqlSupport.lastIndexUpdateTime).equalTo(record::getLastIndexUpdateTime)
                        .set(BookDynamicSqlSupport.isVip).equalTo(record::getIsVip)
                        .set(BookDynamicSqlSupport.status).equalTo(record::getStatus)
                        .set(BookDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                        .set(BookDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                        .set(BookDynamicSqlSupport.crawlSourceId).equalTo(record::getCrawlSourceId)
                        .set(BookDynamicSqlSupport.crawlBookId).equalTo(record::getCrawlBookId)
                        .set(BookDynamicSqlSupport.crawlLastTime).equalTo(record::getCrawlLastTime)
                        .set(BookDynamicSqlSupport.crawlIsStop).equalTo(record::getCrawlIsStop)
                        .where(BookDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Book record) {
        return update(c ->
                c.set(BookDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
                        .set(BookDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
                        .set(BookDynamicSqlSupport.catName).equalToWhenPresent(record::getCatName)
                        .set(BookDynamicSqlSupport.picUrl).equalToWhenPresent(record::getPicUrl)
                        .set(BookDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                        .set(BookDynamicSqlSupport.authorId).equalToWhenPresent(record::getAuthorId)
                        .set(BookDynamicSqlSupport.authorName).equalToWhenPresent(record::getAuthorName)
                        .set(BookDynamicSqlSupport.bookDesc).equalToWhenPresent(record::getBookDesc)
                        .set(BookDynamicSqlSupport.score).equalToWhenPresent(record::getScore)
                        .set(BookDynamicSqlSupport.bookStatus).equalToWhenPresent(record::getBookStatus)
                        .set(BookDynamicSqlSupport.visitCount).equalToWhenPresent(record::getVisitCount)
                        .set(BookDynamicSqlSupport.wordCount).equalToWhenPresent(record::getWordCount)
                        .set(BookDynamicSqlSupport.commentCount).equalToWhenPresent(record::getCommentCount)
                        .set(BookDynamicSqlSupport.yesterdayBuy).equalToWhenPresent(record::getYesterdayBuy)
                        .set(BookDynamicSqlSupport.lastIndexId).equalToWhenPresent(record::getLastIndexId)
                        .set(BookDynamicSqlSupport.lastIndexName).equalToWhenPresent(record::getLastIndexName)
                        .set(BookDynamicSqlSupport.lastIndexUpdateTime).equalToWhenPresent(record::getLastIndexUpdateTime)
                        .set(BookDynamicSqlSupport.isVip).equalToWhenPresent(record::getIsVip)
                        .set(BookDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                        .set(BookDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                        .set(BookDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                        .set(BookDynamicSqlSupport.crawlSourceId).equalToWhenPresent(record::getCrawlSourceId)
                        .set(BookDynamicSqlSupport.crawlBookId).equalToWhenPresent(record::getCrawlBookId)
                        .set(BookDynamicSqlSupport.crawlLastTime).equalToWhenPresent(record::getCrawlLastTime)
                        .set(BookDynamicSqlSupport.crawlIsStop).equalToWhenPresent(record::getCrawlIsStop)
                        .where(BookDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}