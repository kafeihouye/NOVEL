<template>
	<view class="content">
		<aloys-tab :tabs="tabs" @change="onTabChange">
			<view slot="content0" class="aloysTabContent">
				<manRanking :rankingList="rankingList"></manRanking>
				<view class="isOver" v-if="flag">-----数据已经到底了------</view>	
			</view>
			<view slot="content1" class="aloysTabContent">
				<manRanking :rankingList="rankingList"></manRanking>
				<view class="isOver" v-if="flag">-----数据已经到底了------</view>	
			</view>
		</aloys-tab>
	</view>
</template> 

<script>

	import aloysTab from "@/components/aloys-tab/aloys-tab.vue"
	import manRanking from "@/components/rankinglist/man-ranking.vue" //man-ranking -> manRanking
	import womanRanking from "@/components/rankinglist/woman-ranking.vue" //woman-ranking -> womanRanking

	import 
	{
		getBookCategory,
		getBookList,
		getBookListByWorkDirection,
	} 
	from "@/common/api/book.js"

	export default {
		components: {
			aloysTab,
			manRanking,
			womanRanking
		},
		data() {
			return {
				pageNum: 1,
				pageSize: 10,
				total: 0,
				rankingList: [],
				flag: false,//用于显示数据见底输出提示信息
				tabs: [{
					title: '男生'
				}, {
					title: '女生'
				}],
			}
		},
		onPullDownRefresh() {
			console.log("触发下拉刷新")
		},
		onReachBottom() {
			console.log("数据触底了")
			this.pageNum ++
			
			console.log(this.pageNum,"当前页码")
					
			if(this.pageNum > this.total/this.pageSize){
				//数据已经拉取完，没有了
				flag =true
				console.log("数据已经拉取完，没有了,显示提示信息")
			}else{
					this.initBooks()
			}
		},
		onLoad() {
			this.initBooks();
		},
		methods: {
			onTabChange(index) {
				// uni.showToast({
				// 	title: '切换至tab：' + index
				// })
				this.pageNum=1
				this.pageSize= 10
				this.total= 0
				this.rankingList = []
				this.initBooksByWorkDirection(index)
			},
			
			//获取小说
			async initBooks(){
				let res = await getBookListByWorkDirection(this.pageNum,this.pageSize,"0")
				console.log(res,"小说新书榜单")
				//设置总记录数
				this.total = res.data.total
				console.log(this.total,"总记录数")
				this.rankingList  = [...this.rankingList,...res.data.list]
				console.log(this.rankingList,"设置的新书榜单")
			},
			
			async initBooksByWorkDirection(workDirection){
				let res = await getBookListByWorkDirection(this.pageNum,this.pageSize,workDirection)
				console.log(workDirection,res,"获取小说依据作品分类")
				//设置总记录数
				this.total = res.data.total
				console.log(this.total,"总记录数")
				this.rankingList  = [...this.rankingList,...res.data.list]
				console.log(this.rankingList,"设置的新书榜单")
			},
			
			//点击查看小说详情 公共函数，所有循环的对象都必须定义成item
			bookDetailClick(book) {
				console.log(book,"当前点击的数据")
				console.log(book.item.id,"当前点击的数据的id")
				uni.navigateTo({
					url: '/pages/bookdetail/bookdetail?bookId=' + book.item.id,
			
				})
			},
		}
	}
</script>

<style scoped>
	page{
		height: auto;
	}
	.content {
		height:1500rpx;		
	}

	.aloysTabContent {
		font-size: 42rpx;
		font-weight: bold;
		padding: 100rpx 0;
		text-align: center;
		width: 100%;
		height: 1000rpx;
	}
	
	man-ranking{
		width: 500rpx;
		height: 1000rpx;
	}
</style>
