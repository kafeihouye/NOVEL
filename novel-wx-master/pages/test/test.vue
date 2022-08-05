<template>
	<view>
		<view> <textarea>测试首次编码</textarea> </view>
		<view v-for="(item,index) in bookCategoryList" :key="item.id">
			<view> {{item.id}} {{item.name}}</view>
		</view>
	</view>
</template>

<script>
	import {
		getBookCategory,getBookList
	} from '@/common/api/test.js'
	
	export default {
		data() {
			return {
				bookCategoryList:[]
			}
		},
		onLoad() {
			this.initBookCategory()
		},
		methods: {
			initBookCategory:function(){
				getBookCategory().then(res => { 
					console.log("返回数据："+ res.data)
					this.bookCategoryList = res.data;
				})
			}
		}
	}
</script>

<style>

</style>
