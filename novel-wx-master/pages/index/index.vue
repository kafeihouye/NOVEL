<template>
	<view class="content">
		<aloys-tab :tabs="tabs" @change="onTabChange">
			<view slot="content0" class="tabContent">
			 <lv-select
			        @handleSearch = "handleSearch"
			        @change = "change"
			        placeholder = "请输入信息"
			        :infoList = "infoList"
					:showValue = "showValue"
			        v-model = "searchValue"
			        :loading = "loading"
			        type = "success "
			        :uniShadow = "true"
			        ></lv-select>
			<booklist></booklist>
			</view>
			<view slot="content1" class="tabContent">
				<lv-select
				        @handleSearch = "handleSearch"
				        @change = "change"
				        placeholder = "请输入信息"
				        :infoList = "infoList"
						:showValue = "showValue"
				        v-model = "searchValue"
				        :loading = "loading"
				        type = "success "
				        :uniShadow = "true"
				        ></lv-select>
				<booklistworman></booklistworman>
			</view>
			<!--
			<view slot="content2" class="tabContent">
				<publish></publish>
			</view>
			-->
		</aloys-tab>
	</view>
</template>

<script>
	import aloysTab from "@/components/aloys-tab/aloys-tab.vue"
	import lvSelect from '../../components/lv-select/lv-select'
	import booklist from '../../components/booklist/booklist.vue'
	import icon from '../../components/dn-icon/dn-icon.vue'
	import booklistworman from '../../components/booklist/booklistworman.vue'
	import publish from "../../components/publish/publish.vue"
	
	import {
		getBookCategory,getBookList
	} from '@/common/api/book.js'

	export default {
		
		components: {
			aloysTab,
			lvSelect,
			booklist,
			icon,
			booklistworman,
			publish,
		
		},
		data() {
			return {
				picUrl:"",
				 loading: false,
                showValue: 'name', // 需要显示的数据，必须与infoList中的name对应
                searchValue: '',
                infoList: [],
                infoLists: [{
                    name: '遮天'
                },{
                    name: '神墓'
                },{
                    name: '完美世界'
                },{
                    name: '圣墟'
                }],
				tabs: [{
					title: '男生'
				}, {
					title: '女生'
				}]
			}
		},
		onReachBottom() {
			console.log('触发下拉刷新了')
		},
		methods: {
			//tab切换
			onTabChange(obj) {
				uni.showToast({
					title: '切换成功',
					icon: 'none',
					duration:500,
					mask:false

				})
			},
			handleSearch() {
			                this.loading = true
			                setTimeout(() => {
			                    this.loading = false
			                    this.infoList = this.infoLists
			                }, 2000)
			            },
						
						

		},
		
		      // onLoad: function (options) {
		      //      setTimeout(function () {
		      //          console.log('start pulldown');
		      //      }, 1000);
		      //      uni.startPullDownRefresh();
		      //  },
		      onPullDownRefresh(){
		      	console.log('触发下拉刷新了')
		      }

		
	}
	
</script>

<style>
	.content {
		position: absolute;
		height: 100%;
	}

	.tabContent {
		width: 100%;
		font-size: 42rpx;
		font-weight: bold;
		padding: 10rpx 0;
		text-align: center;
	}
</style>
