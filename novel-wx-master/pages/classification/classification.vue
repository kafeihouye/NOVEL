<template>
	<view class="pics">
		<scroll-view class="left" scroll-y>
			<view @click="leftClickNav(item.id,item)" v-for="(item,index) in name" :key="item.name" :class="{'active':active==item.id}">{{item.name}}</view>
		</scroll-view>
		<scroll-view class="right" scroll-y>

			<block v-for="item in bookItems" :key="item.id">
				<!-- 跳转详情页面 -->

				<view class="right-box" @click="details(item)">
					<view class="right-boxs" style="width: 100%; height: 100%;">
						<text space="nbsp">{{ item.bookName}}</text>
						<view class="img">
							<image :src="item.picUrl" class="img-b"></image>
							<image :src="item.picUrl" class="a"></image>

						</view>
					</view>
				</view>
			</block>

		</scroll-view>
	</view>
</template>

<script>
	import {
		getBookCategory,
		getBookListByCategoryId
	} from "@/common/api/book.js"
	
	
	export default {
		data() {
			return {
				
				//当前激活的分类
				active: 0,
				name: [],//小说分类名称
				bookItems: [],
				total: "",
				pageNum: 1,
				pageSize: 12,
				flag:false,
			};
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
					this.initBookList(this.active)
			}
			
		},
		//#ifdef MP-ALIPAY
		onReady: function() {
			
		},

		//#endif 
		//#ifdef MP-WEIXIN||H5
		onLoad() {
			this.initBookCategory()
		},
		//#endif
		methods: {
			//#ifdef MP-WEIXIN||H5
			/**
			 * 获取小说分类
			 */
			async initBookCategory() {
				let res = await getBookCategory();
				console.log(res)
				this.name = res.data
				//this.items = this.name[0].items;
				this.active = res.data[0].id
				this.initBookList(this.active)
			},
			async initBookList(active){
				let res = await getBookListByCategoryId(this.pageNum,this.pageSize,active)
		
				this.bookItems = [...this.bookItems,...res.data.list]
				//设置总记录数
				this.total = res.data.total
			},
			//#endif
			leftClickNav(index, item) {
				this.active = index
				this.bookItems = []
				// 右边栏
				this.initBookList(this.active)
			},
			//跳转到查看小说页面
			goBooks(item){
				uni.navigateTo({
					url:`/pages/bookshelfs/bookshelfs?bookId=${item.id}&m=1`
					
				}) 
			}
		}
		

	}
</script>

<style lang="scss">
	.pics {
		font-size: 28rpx;
		display: flex;

		.left {
			flex: 1;
			width: 150rpx;
			height: 100%;

			view {
				flex: 1;
				height: 60px;
				line-height: 60px;
				color: #333;
				text-align: center;
				font-size: 30rpx;
				border-top: 1px solid #eee;
			}

			.active {
				border-left: 2px solid red;
				background: #f5f5f5;
			}
		}

		.right {
			background: #f5f5f5;
			width: 600rpx;
			height: 100%;
			margin-left: 20rpx;

			.right-box {
				width: 25%;
				// margin-top: 10rpx;
				margin: 40rpx 2.4%;
				height: 190rpx;
				float: left;
				background: #F1F1F1;

				.right-boxs {
					// text-align: center;
					border-radius: 10rpx;
					position: relative;
					// border: 1px solid red;
					// background: #F8F8FF;
					box-shadow: 2px 2px 5px #C8C7CC;

					text {
						border-radius: 10rpx 10rpx 0rpx 0rpx;
						display: inline-block;
						width: 100%;
						height: 20%;
						background: #FFFFFF;
					}

					.img {

						text-align: center;
						position: absolute;
						left: 0rpx;
						top: 67rpx;
						line-height: 100%;
						box-sizing: border-box;
						width: 90%;
						height: 70%;

						image {
							// position: absolute;
							z-index: 1;
							top: 0rpx;
							left: 10rpx;

						}

						.a {
							width: 100rpx;
							height: 90rpx;
							// position: absolute;
							// left: 10rpx;

						}

						.img-b {

							position: absolute;
							right: 20rpx;
							width: 70rpx;
							height: 100rpx;
						}

					}
				}

			}






		}


	}
</style>
