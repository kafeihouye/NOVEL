import request from '@/common/utils/request.js';
import unLoginRequest from '@/common/utils/unloginRequest.js'
import {
	BookCategoryUrl,
	BookListUrl,
	BookByIdAndIndexUrl,
	FirstVisitBookByIdUrl,
	BookCataloguUrl,
	ClickRankUrl,
	NewRankUrl,
	UpdateRankUrl,
	BookDetailByIdUrl,
} from '@/common/api/apiConstant.js'
/**
 * 獲取小说分类
 */
export function getBookCategory() {
	return unLoginRequest({
		url: BookCategoryUrl,
		method: 'get'
	})
}

/**
 * 查询小说
 * @param {} pageNum 当前页
 * @param {*} pageSize 每页显示多少条
 * @param {*} keyword 关键字 书名、作者、关键字 
 */
export function getBookList(pageNum, pageSize, keyword) {
	///book/searchByPage?curr=1&limit=20&keyword=剑起&bookStatus=0&wordCountMax=300000&updatePeriod=3&sort=last_index_update_time
	return unLoginRequest({
		url: BookListUrl+'?curr=' + pageNum + '&limit=' + pageSize 
		+ '&keyword=' + keyword,
		method: 'get'
	})
}


/**
 * 获取小说详情
 * @param {} bookId 小说id
 */
export function getBookDetailById(bookId) {
	return unLoginRequest({
		url: BookDetailByIdUrl+'/' + bookId , 
		method: 'get'
	})
}

/**
 * 首次查看小说
 * @param {} bookId 小说id
 */
export function getFirstVisitBookById(bookId) {
	///book/searchByPage?curr=1&limit=20&keyword=剑起&bookStatus=0&wordCountMax=300000&updatePeriod=3&sort=last_index_update_time
	return unLoginRequest({
		url: FirstVisitBookByIdUrl+'/' + bookId , 
		method: 'get'
	})
}

/**
 * 查看小说
 * @param {} bookId 小说id
 * @param {*} bookIndexId 目录id
 */
export function getBookByIdAndIndex(bookId, bookIndexId) {
	///book/searchByPage?curr=1&limit=20&keyword=剑起&bookStatus=0&wordCountMax=300000&updatePeriod=3&sort=last_index_update_time
	return unLoginRequest({
		url: BookByIdAndIndexUrl+'/' + bookId + '/' + bookIndexId,
		method: 'get'
	})
}


/**
 * 获取小说的目录 不分页
 * @param {} bookId 小说id
 */
export function getBookCatalogu(bookId) {
	return unLoginRequest({
		url: BookCataloguUrl+'/' + bookId,
		method: 'get'
	})
}

/**
 * 小说点击榜  
 */
export function getClickRankBook() {
	return unLoginRequest({
		url: ClickRankUrl+'?pageSize=12',
		method: 'get'
	})
}

/**
 * 小说新书榜  
 */
export function getNewRankBook() {
	return unLoginRequest({
		url: NewRankUrl,
		method: 'get'
	})
}

/**
 * 小说更新榜  
 */
export function getUpdateRankBook() {
	return unLoginRequest({
		url: UpdateRankUrl,
		method: 'get'
	})
}

/**
 * 查询小说依据作品频道分页
 * @param {} pageNum 当前页
 * @param {*} pageSize 每页显示多少条
 * @param {*} workDirection  作品频道 0 男 1 女 
 */
export function getBookListByWorkDirection(pageNum, pageSize, workDirection) {
	//workDirection = 0 男 1 女
	///book/searchByPage?curr=1&limit=20&keyword=剑起&bookStatus=0&wordCountMax=300000&updatePeriod=3&sort=last_index_update_time
	return unLoginRequest({
		url: BookListUrl+'?curr=' + pageNum + '&limit=' + pageSize 
		+ '&workDirection=' + workDirection,
		method: 'get'
	})
}

/**
 * 查询小说依据作品分类分页
 * @param {} pageNum 当前页
 * @param {*} pageSize 每页显示多少条
 * @param {*} category  作品分类
 */
export function getBookListByCategoryId(pageNum, pageSize, category) {
	//catId 作品分类
	///book/searchByPage?curr=1&limit=20&keyword=剑起&bookStatus=0&wordCountMax=300000&updatePeriod=3&sort=last_index_update_time
	return unLoginRequest({
		url: BookListUrl+'?curr=' + pageNum + '&limit=' + pageSize 
		+ '&catId=' + category,
		method: 'get'
	})
}