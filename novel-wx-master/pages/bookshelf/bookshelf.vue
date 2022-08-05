<template>
	<view class="content">
		<view class="zi">书架</view>
		<view class="zt"><text class="z1">共<text class="jiu">{{total}}</text>本书</text></view>
		
		<uni-list>
			<uni-list-item v-for="(item,index) in books" :key="item.id" link to=""  :thumb="item.picUrl" thumbSize="lg">
				<view slot="body" class="item slot-box slot-text" @click="goBooks(item)">
					<view class="tit">{{item.bookName}}</view>
					<view class="swyd">
						<text class="zz" v-model="text">尚未阅读</text>
					</view>
					<view class="shop-price">
						<text class="ny">最新</text>
						<text class="shop-price-text">{{ item.lastIndexName  }}</text>
					</view>

				</view>
			</uni-list-item> 
		</uni-list>
		<view class="isOver" v-if="flag">-----数据已经到底了------</view>
	</view>
</template>

<script>
	import uniList from "@/components/uni-ui/uni-list/uni-list.vue"
	import uniListItem from "@/components/uni-ui/uni-list-item/uni-list-item.vue"
	import myRequestGet from "../../utils/zgrequest.js"
	import {
		getBookCategory,getBookList
	} from '@/common/api/book.js'
	
	export default {
		data() {
			return {
				books: [],
				total: "",
				pageNum: 1,
				pageSize: 10,
				flag:false,

				
			}
		},
		components: {
			uniList,
			uniListItem
		
		},
		onLoad() {
			this.getBooks()
			
		},
		onPullDownRefresh() {
			console.log("触发下拉刷新")
		},
		onReachBottom() {
			console.log("数据触底了")
			this.pageNum ++
			
		
			if(this.pageNum > this.total/this.pageSize){
				//数据已经拉取完，没有了
				flag =true
			}else{
					this.getBooks()
			}
			
			//let result = await getBookList(2,5,"")
			// //翻页
			// this.books = [...this.books,result.data.list]
		},
		methods: {
			//获取小说列表
			async getBooks() {
				let result = await getBookList(this.pageNum,this.pageSize,"")
				console.log("获取的小说列表：",result.data)
				//设置小说列表
				//this.books = result.data.list
				this.books = [...this.books,...result.data.list]
				//设置总记录数
				this.total = result.data.total
			},
			//跳转到查看小说页面
			goBooks(item){
				uni.navigateTo({
					url:`/pages/bookshelfs/bookshelfs?bookId=${item.id}&m=1`
					
				})
			}
			
			
		},
		

	}
</script>




<style>
	.zi {
		width: 100%;
		height: 30px;
		font-size: 20px;
		font-weight: 800;
		text-align: center;
		margin-top: 20rpx;

	}

	image {
		height: 85px !important;
		width: 65px !important;
	}

	.uni-title {
		margin-left: 15rpx;

	}

	.uni-ellipsis-2 {
		font-size: 33rpx;
		color: #333333;
	}

	.swyd {

		margin: 15rpx;
		margin-left: 25rpx;
	}

	.zz {
		color: #777777;
		font-size: 25rpx;
	}

	.shop-price {
		margin: 15rpx;
		margin-left: 12rpx;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
    uni-image{
		width: 65px!important;
		height: 85px!important;

	}
	.uni-list-item__icon{
		width: 65px!important;
		height: 85px!important;
	}
     .uni-list--base{
		 display: inline-block;
		 width: 65px!important;
		 height: 85px!important;
	 }

	.shop-price-text {
		color: #777777;
		font-size: 25rpx;


	}

	.uni-list--border-top {
		display: none;

	}

	.uni-list--border {
		display: none;
	}

	.ny {

		border: 1rpx solid red;
		margin: 10rpx;
		padding: 5rpx 8rpx;
		font-size: 20rpx;
		font-weight: 100;
		color: red;
	}
	.zt{
		margin-left: 30rpx;
		margin-bottom: 20rpx;
	}
	.z1{
		color: #777777;
		
		
	}
	.jiu{
		color: red;
		font-size: 45rpx;
		margin: 0 5rpx;
	}
	.delete{
		float: right;
		margin-top: -70rpx;
		margin-right: 20rpx;
	}
	
	
</style>
