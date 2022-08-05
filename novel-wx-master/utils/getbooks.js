//const baseUrl = "https://www.nsdciot.com/"

import { requestURL } from '@/common/utils/config.js'

export default function myRequestGet(url, data) {
	
	var requesturl = ""
	requesturl = requestURL + url;
	// #ifdef H5
	requesturl = url;
	// #endif
	console.log(requestURL + url)
	return new Promise((resolve, reject) => {
		uni.request({
			url: requesturl,
			method: "GET",
			data: data,
			success: function(res) {
				console.log("res",res)
				resolve(res.data)
			},
			fail: function(err) {
				console.log("err",err)
				reject(err)
			}
		})
	})



}

export function myRequestPost(url, data) {
	return new Promise((resolv, reject) => {
		uni.request({
			url: requestURL + url,
			header: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			method: "POST",
			data: data,
			success: function(res) {
				resolve(res.data)
			},
			fail: function(err) {
				reject(err)
			}
		})
	})



}
