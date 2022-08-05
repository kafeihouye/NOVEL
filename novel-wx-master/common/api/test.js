import request from '@/common/utils/request.js';
import unLoginRequest from '@/common/utils/unloginRequest.js'
/**
 * 獲取小说分类
 */
export function getBookCategory() {
	return unLoginRequest({
		url: '/listBookCategory',
		method: 'get'
	})
}

/**
 * 获取小说
 * @param {} pageNum 
 * @param {*} pageSize 
 * @param {*} hospitalName 
 */
export function getBookList(pageNum, pageSize, hospitalName) {
	return unLoginRequest({
		url: '/hospital/info/list?pageNum=' + pageNum + '&pageSize=' + pageSize 
		+ '&hospitalName' + hospitalName,
		method: 'get'
	})
}