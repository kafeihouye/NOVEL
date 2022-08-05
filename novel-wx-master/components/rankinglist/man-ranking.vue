<template>
	<view class="all">
		<view class="box" v-for="(item, index) in rankingList" :key="index" >
			<view class="books" @click="bookDetailClick({item})">
				<image class="img" :src="item.picUrl" mode="widthFix" style="width: 150rpx"></image>
				<view class="content">
					<view class="tit">{{item.bookName}}</view>
					<text class="num">{{index+1}}</text>
					<view class="info">
						<view class="desc">{{item.bookDesc}}</view>
						<view class="author">{{item.authorName}}</view>
						<view class="category">{{item.catName}}</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default { 
		props: ['rankingList'],
		data(){
			return {
				
			}
		},
		methods: {
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

<style lang="scss" scoped>
	.all {}

	.books {
		width: 100%;
		height: 240rpx;
	}

	.img {
		float: left;
	}

	.content {
		width: 550rpx;
		float: left;
		//间距
		margin-left: 22rpx;
		margin-top: 5rpx;
		text-align: left;
	}
	
	.tit{
		display: inline-block;
		font-size: 30rpx;
	}
	
	.num{
		float: right;
		color: red;
	}
	
	.info {
		margin-top: 10rpx;
	}

	.desc {
		font-size: 26rpx;
		color: #777777;
		/* 超出部分隐藏 */
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		overflow: hidden;
	}

	.author {
		color: #777777;
		font-size: 30rpx;
		//间距
		margin-top: 55rpx;
		display: inline-block;
	}

	.category {
		border: 1px solid gray;
		float: right;
		color: gray;
		font-size: 25rpx;
		padding: 2rpx 15rpx;
		margin-top: 55rpx;
	}
</style>
