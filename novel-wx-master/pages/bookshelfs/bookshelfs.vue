<template>
	<view class="content">
		<view class="wz">
			<!--#ifdef MP-WEIXIN-->
			<view class="zi">{{bookIndex.indexName}}</view>
			<rich-text :nodes="bookContent.content"></rich-text>
			<!--#endif-->

			<!--#ifdef H5-->
			<view v-html="bookContent.content" class="sss" style=""></view>
			<!--#endif-->

			<!--#ifdef MP-ALIPAY-->
			<rich-text :nodes="bookContent.content"></rich-text>
			<!--#endif-->
		</view>





		<view class="progress-box">
			<text @click="goPreChapter">上一章</text>
			<text @click="getMulv(item)">目录</text>
			<text @click="goNextChapter">下一章</text>

		</view>


	</view>
</template>

<script>
	import myRequestGet from "../../utils/getbooks.js"
	
	
	import {
		getBookByIdAndIndex,
		getFirstVisitBookById,
	} from '@/common/api/book.js'
	
	export default {
		props: ["url"],
		data() {
			return {
				bookId: "",//小说id
				bookss: [],
				p1: 1,
				text: "",
				m: "",
				index:"",//小说目录id
				bookContent:"",//小说内容
				bookIndex:"",//小说章节
				preBookIndexId:"",//上一章
				nextBookIndexId:"",//下一张
				


			}
		},

		onLoad(options) {
			this.m = options.m
			
			this.bookId = options.bookId
			console.log("传递的参数：",options.bookId,"###m=",options.m)
			if (this.m == 1) {
				this.getnewsBooks()
				
			} else {
				//小说章节目录
				this.index = options.index
				//this.text = this.url.slice(0, 15)
				//this.getUrl()
				this.initBookByIdAndIndex();
				
			}
			//屏蔽
			//this.sssss()


		},





		methods: {
			sssss: function() {
				this.text = this.url.slice(0, 15)
				this.index = this.index
				console.log(this.text,this.index)
			},
			async getnewsBooks() {
				const res = await getFirstVisitBookById(this.bookId)
				console.log(res, "小说内容")
				this.bookContent = res.data.bookContent
				this.bookIndex = res.data.bookIndex
				this.preBookIndexId = res.data.preBookIndexId
				this.nextBookIndexId = res.data.nextBookIndexId

			},
			async initBookByIdAndIndex() {
				const res = await getBookByIdAndIndex(this.bookId,this.index)
				console.log(res)
				this.bookContent = res.data.bookContent
				this.bookIndex = res.data.bookIndex
				this.preBookIndexId = res.data.preBookIndexId
				this.nextBookIndexId = res.data.nextBookIndexId
			},
			//上一章
			goPreChapter() {
				this.p1--;
				this.index = this.preBookIndexId
				if(this.index === 0 || this.index === '0' ){
					this.getnewsBooks()
				}else{
					this.initBookByIdAndIndex()
				}
				
				//this.getnewsBooks()
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 300
				})

			},
			goNextChapter() {
				this.p1++;
				this.index = this.nextBookIndexId
				this.initBookByIdAndIndex()
				//this.getnewsBooks()
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 300
				})

			},
			//目录
			getMulv(item) {
				uni.navigateTo({
					url: `/pages/mulv/mulv?bookId=${this.bookId}`

				})
			},

			tapscroll: function() {
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 300
				})
			},



		}
	}
</script>

<style lang="scss" scoped>
	.content {
		background: rgba(199, 237, 204, 255);
		padding: 5px;
	}

	.progress-box {
		width: 100%;
		height: 60px;
		display: flex;

		text {
			flex: 1;
			display: inline-block;
			width: 70px;
			height: 25px;
			margin: 10px 10px;
			border: 3rpx solid black;
			text-align: center;
			border-radius: 20px;
			font-size: 35rpx;
			color: #777777;
			padding: 8px;

		}
	}

	.wz {
		font-size: 18px;
		padding: 15px;

	}

	/deep/.zhangyue-tablebody {
		font-weight: normal;
		zy-fontsize-adjust: fixed;
		width: 100%;
		height: 100%;
		padding-left: 7%;
		padding-right: 7%;
		border: 1px solid black;
	}

	/deep/.biaoti {
		font-size: 20px;
		font-weight: bold;
		line-height: 1.2em;
		border-bottom: 1rpx solid #F1F1F1;
		width: 100%;
	}

	/deep/.kaiti {
		font-size: 12px;
		font-weight: normal;
		line-height: 2.6em;
	}

	/deep/.copyright {
		font-size: 10px;

	}

	/deep/.lantinghei {
		font-size: 10px;
		line-height: 1.7em;
	}

	/deep/.dotStyle2 {
		padding-left: 0.2em;
		padding-right: 0.2em;
		font-weight: bold;
		font-size: 12px;
	}

	/deep/.text-title-1 {
		font-size: 20px;
		line-height: 1.2em;
		font-weight: bold;
		margin-top: 10%;
		text-align: center;
		margin-bottom: 1.3em;
		zy-text-type: main-body;
	}

	/deep/.bodytext {
		zy-text-type: main-body;
		font-size: 18px;
		zy-text-indent: auto;
		text-indent: 2em;
		margin-bottom: 3px;
	}
</style>
