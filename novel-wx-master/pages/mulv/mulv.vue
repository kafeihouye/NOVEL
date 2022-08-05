<template>
	<view class="ml">
		<view class="head">共{{bookIndexCount}}章</view>
		<view class="">
			<view class="" v-for="(item,index) in bookIndexList" :key="item.id">
				<view class="chapter" @click="getChapter(item)">
					<text class="chapter_s">{{item.indexName}}</text>
				</view>
			</view>
		
		</view>

	</view>
</template>


<script>
	import myRequestGet from "../../utils/getbooks.js"
	import uniPagination from '@/components/uni-ui/uni-pagination/uni-pagination.vue'
	
	import {getBookCatalogu} from '@/common/api/book.js'
	
	export default {
		data() {
			return {
				bookId: "",
				bookIndexList: [],
				bookIndexCount:"",

			}
		},
		components: {
			uniPagination
		},
		onLoad(options) {
			this.bookId = options.bookId
			this.getMulv()
		},
		methods: {
			async getMulv() {
				const res = await getBookCatalogu(this.bookId)
				console.log(res.data)
				this.bookIndexList = res.data.bookIndexList
				this.bookIndexCount = res.data.bookIndexCount
			},
			getChapter(item) {
				uni.navigateTo({
					url: `/pages/bookshelfs/bookshelfs?url=${item.url}&bookId=${this.bookId}&index=${item.id}`
				})
			},
			
		}
	}
</script>

<style>
	.ml {
		background: rgba(199, 237, 204, 255);
	}

	.head {
		color: #999999;
		font-size: 25px;

	}

	.chapter {
		width: 100%;
		height: 60px;
		border-bottom: 1rpx solid #F1F1F1;
		line-height: 30px;
		font-size: 20px;
		text-align: left;

	}

	.chapter_s {
		line-height: 60px;
		text-align: center;
	}
</style>
