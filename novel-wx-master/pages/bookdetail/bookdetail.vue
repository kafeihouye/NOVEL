<template>
	<view class="page" v-if="isshow">
		<view class='bg'>
			<image :src="picUrl" mode="scaleToFill"></image>
			<view class="bg-left">
				<p>{{bookName}}</p>
				<text>{{author}}&nbsp|&nbsp{{category}}</text>
				<text>{{wordCount}}&nbsp&nbsp{{popularity}}</text>
				<text>{{bookRating}}分</text>
			</view>
		</view>
		<view class="info">

			<text :class="geshi">{{desc}}</text>
			<view class="tags">
				<text>{{tag[0]}}</text>
				<text>{{tag[1]}}</text>
				<text>{{tag[2]}}</text>
				<text>{{tag[3]}}</text>
				<view @click="more">详情</view>
			</view>
			<view class="state">
				<text class="catalog">目录</text>
				<a class="chapter" href="#">更新至第{{chapterCount}}章</a>
				<text class="completeState">{{completeState}}</text>
			</view>
		</view>
		<view class="comment">
			<p>热评</p>
			<view class="nocomment" v-show="commentList[0]==null">
				抱歉，本书暂无评论
			</view>
			<view class="commentlist"  v-show="!commentList">
				<image :src="commentList[0].avatar"></image>
				<p>{{commentList[0].nick}}</p>
				<text>{{commentList[0].content}}</text>
			</view>
			<view class="commentlist">
				<image :src="commentList[1].avatar"></image>
				<p>{{commentList[1].nick}}</p>
				<text>{{commentList[1].content}}</text>
			</view>
			<view class="commentlist">
				<image :src="commentList[2].avatar"></image>
				<p>{{commentList[2].nick}}</p>
				<text>{{commentList[2].content}}</text>
			</view>
		</view>
		<!-- 
		<view class="bottom">
			<p>书友还读过</p>
			<view class="recommenList">
				<view class="recommend" @click=bookClick1({newBooksRecommend})>
					<image :src="newBooksRecommend[0].picUrl"></image>
					<text>{{newBooksRecommend[0].bookName}}</text>
				</view>
				<view class="recommend" @click=bookClick2({newBooksRecommend})>
					<image :src="newBooksRecommend[1].picUrl"></image>
					<text>{{newBooksRecommend[1].bookName}}</text>
				</view>
				<view class="recommend" @click=bookClick3({newBooksRecommend})>
					<image :src="newBooksRecommend[2].picUrl"></image>
					<text>{{newBooksRecommend[2].bookName}}</text>
				</view>
			</view>
		</view>
		-->
		<uni-goods-nav :fill="false" :options="options" :buttonGroup="buttonGroup" @click="onClick" @buttonClick="buttonClick" />
	</view>
</template>

<script>
	import {
		myRequestGet
	} from "@/utils/xsrequest.js"
	import uniGoodsNav from '@/components/uni-ui/uni-goods-nav/uni-goods-nav.vue'
	
	
	import
	{
		getBookDetailById,
	} 
	from "@/common/api/book.js"
	
	export default {
		components: {
			uniGoodsNav
		},
		data() {
			return {
				isshow:false,
				bookId: '', //小说id
				firstBookIndexId:'',//小说的第一章
				dataObj: {},
				bookInfos: {},
				bookName: "",
				author: "",
				bookRating: "",
				category: "",
				chapterCount: "",
				completeState: "",
				desc: "",
				picUrl: '',
				popularity: "",
				wordCount: "",
				tag: [],
				commentList: [],
				newBooksRecommend: [],
				geshi: "desc",
				bookInfo: {},
				options: [{
					icon: 'undo',
					text: '分享给好友'
				}, 
				{
					icon: 'star',
					text: '加入书架',
					info: 2
				}],
				buttonGroup: [
					{
						text: '立即阅读',
						backgroundColor: '#ffa200',
						color: '#fff'
					}
				]
			}
		},
		onLoad(options) {
			this.bookId = options.bookId
			console.log(options.bookId, "xxxxxxxxx")
			//this.getData();
			this.initBookDetail()
		},
		created() {
			//this.initBookDetail()
		},
		//#ifdef MP-ALIPAY
		methods: {
			
			async getData() {
			},
			more: function() {
				if (this.geshi == "desc") {
					this.geshi = ""
				} else(
					this.geshi = "desc"
				)
			},
			//点击添加
			bookClick1(newBooksRecommend) {
			  this.id=newBooksRecommend.newBooksRecommend[0].bookId; 
			  this.getData();
			},
			bookClick2(newBooksRecommend) {
				this.id=newBooksRecommend.newBooksRecommend[1].bookId;
				this.getData();
			
			},
			bookClick3(newBooksRecommend) {
				this.id=newBooksRecommend.newBooksRecommend[2].bookId;
				this.getData();
			
			},
			
		},
		//#endif
		//#ifdef H5||MP-WEIXIN
		methods: {
			async initBookDetail(){
				let res = await getBookDetailById(this.bookId)
				console.log(res,"获取小说详情")
				//设置小说对象
				this.bookInfo=res.data.book;
				this.firstBookIndexId = res.data.firstBookIndexId;
				//书名
				const bookName = res.data.book.bookName;
				this.bookName = bookName;
				console.log(bookName,"小说名称")
				//作者
				const author = res.data.book.authorName;
				this.author = author;
				//评分
				const bookRating = res.data.book.score;
				this.bookRating = bookRating;
				//分类
				const category = res.data.book.catName;
				this.category = category;
				
				//封面
				const picUrl = res.data.book.picUrl;
				this.picUrl = picUrl
				// //简介
				const bookDesc = res.data.book.bookDesc;
				this.desc = bookDesc;
				
				// //章数
				const lastIndexName = res.data.book.lastIndexName;
				this.chapterCount = lastIndexName;
					
				this.isshow=true;
					
				// //章数
				// const chapterCount = res.data.body.bookInfo.chapterCount;
				// this.chapterCount = chapterCount;
				// //状态
				// const completeState = res.data.body.bookInfo.completeState;
				// this.completeState = completeState;
				// //简介
				// const desc = res.data.body.bookInfo.desc;
				// this.desc = desc;
				// //封面
				// const picUrl = res.data.body.bookInfo.picUrl;
				// this.picUrl = picUrl;
				// //人气
				// const popularity = res.data.body.bookInfo.popularity[0] + res.data.body.bookInfo.popularity[1];
				// this.popularity = popularity;
				// //字数
				// const wordCount = res.data.body.bookInfo.wordCount[0] + res.data.body.bookInfo.wordCount[1];
				// this.wordCount = wordCount;
				// //标签
				// const tag = res.data.body.bookInfo.tag;
				// this.tag = tag;
				
			},
			buttonClick (e) {
			    console.log(e,"立即阅读")
			    //this.options[2].info++
				uni.navigateTo({
					url: `/pages/bookshelfs/bookshelfs?bookId=${this.bookInfo.id}&index=${this.firstBookIndexId}`
				})
			},
			more: function() {
				if (this.geshi == "desc") {
					this.geshi = ""
				} else(
					this.geshi = "desc"
				)
			},
			//点击添加
			bookClick1(newBooksRecommend) {
			  this.id=newBooksRecommend.newBooksRecommend[0].bookId; 
			  this.getData();
			},
			bookClick2(newBooksRecommend) {
				this.id=newBooksRecommend.newBooksRecommend[1].bookId;
				this.getData();
			
			},
			bookClick3(newBooksRecommend) {
				this.id=newBooksRecommend.newBooksRecommend[2].bookId;
				this.getData();
			
			},
			
		},
		//#endif
		onPullDownRefresh() {
			uni.stopPullDownRefresh();
			uni.hideNavigationBarLoading();
			this.getData();
		},
		
	}
</script>

<style lang="scss" scoped>
	.page{
		height: 1000rpx;
	}
	uni-goods-nav{
		position: fixed;
		bottom: 0px;
		width: 100%;
	}
	.bg {
		width: 100%;
		height: 280rpx;
		display: block;
		z-index: -999;
		color: #FFFFFF;
		background-color: #b0b0b0;
		padding-top: 50rpx;
		image {
			width: 178rpx;
			height: 238rpx;
			float: right;
			margin-right: 50rpx;
		}
		.bg-left {
			padding-left: 50rpx;
			p {
				font-weight: 1000;
				font-size: 40rpx;
			}
			text {
				display: block;
				margin-top: 10rpx;
			}
		}
	}
	.info {
		color: #8c8c8c;
		line-height: 50rpx;
		padding: 20rpx;
		.desc {
			overflow: hidden;
			text-overflow: ellipsis;
			display: -webkit-box;
			-webkit-line-clamp: 3;
			-webkit-box-orient: vertical;
		}
		.tags {
			border-bottom: solid rgba(220, 220, 220, 0.3) 2rpx;
			padding-bottom: 30rpx;
			text {
				display: inline-block;
				height: 40rpx;
				width: 100rpx;
				background-color: #F8F8F8;
				line-height: 40rpx;
				text-align: center;
				border-radius: 20rpx;
				margin-right: 20rpx;
			}
			view {
				display: inline-block;
				float: right;
				margin-right: 20rpx;
			}
		}
		.state {
			margin-top: 20rpx;
			.catalog {
				color: #000000;
				font-size: 40rpx;
			}
			.completeState {
				color: red;
				float: right;
				margin-right: 25rpx;
			}
			.chapter {
				float: right;
			}
		}
	}
	.comment {
		border-top: solid rgba(220, 220, 220, 0.3) 20rpx;
		padding: 20rpx;
		p {
			font-size: 40rpx;
		}
		.nocomment {
			color: #C0C0C0;
			text-align: center;
		}
		.commentlist {
			margin-top: 30rpx;
			image {
				width: 60rpx;
				height: 60rpx;
				border-radius: 50%;
				display: inline-block;
				// vertical-align: bottom;
			}
			p {
				vertical-align: bottom;
				display: inline-block;
				font-size: 30rpx;
				color: #C0C0C0;
				height: 60rpx;
				margin-left: 20rpx;
			}
			text {
				display: block;
				overflow: hidden;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 3;
				-webkit-box-orient: vertical;
				line-height: 45rpx;
			}
		}
	}
	.bottom {
		border-top: solid rgba(220, 220, 220, 0.3) 20rpx;
		padding: 20rpx;
		p {
			font-size: 40rpx;
		}
		.recommenList {
			height: 425rpx;
			display: flex;
			margin-top: 30rpx;
			.recommend {
				flex: 1;
				image {
					width: 178rpx;
					height: 238rpx;
					display: block;
					margin: 0 auto;
				}
				text {
					display: block;
					width: 178rpx;
					margin: 0 30rpx;
				}
			}
		}
	}
</style>