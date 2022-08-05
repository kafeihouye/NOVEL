
/**
 * 参数配置文件
 */
// module.exports = {
//   /**
// 	 * 应用名
// 	 */
//   name: '预约平台',
//   /**
// 	 * 版本
// 	 */
//   version: '1.0.1',
//   /**
// 	 * 开发环境host
// 	 */
//   devHost: 'https://www.nsdciot.com',
//   /**
// 	 * 测试环境转发规则
// 	 */
//   devApi: '/dev-api',
//   /**
// 	 * 生产环境host
// 	 * https://www.fastmock.site/mock/afd80515f2decda152a5f69295a3dce1
// 	 */
//   prodHost: 'https://www.nsdciot.com',
//   /**
// 	 * 生产环境转发规则
// 	 */
//   prodApi: '/prod-api',
//   /**
// 	 * 请求头名称
// 	 */
//   tokenHeadName: 'Authorization',

//   /**
// 	 * 请求头类型
// 	 */
//   tokenTypeName: 'Bearer ',

//   /**
// 	 * 是否开启前端oss直传
// 	 */
//   ossEnable: false,

//   /**
// 	 * 微信公众号appid,填写即代表开启公众号登录
// 	 */
//   wxH5AppId: '',

//   /**
// 	 * 微信公众号授权方式snsapi_base或snsapi_userinfo
// 	 */
//   wxH5scope: 'snsapi_base'
// }

/**
 * api url相对路径常量定义 所有的url相对路径后面不能加/，如果需要加，请在具体js里面补充
 */
//轮播图  get
export const LunboUrl = "/api/getlunbo"

//小说分类
export const BookCategoryUrl ="/book/listBookCategory"

//小说列表
export const BookListUrl ="/book/searchByPage"

//查看小说
export const BookByIdAndIndexUrl = "/wxPage/book"

//小说详情
export const BookDetailByIdUrl = "/wxPage/book"

//首次查看小说 查看小说第一章
export const FirstVisitBookByIdUrl = "/wxPage/firstVisitBook"

//小说目录
export const BookCataloguUrl =  "/wxPage/book/catalogue"

//小说点击榜单
export const ClickRankUrl = "/book/listClickRankLimit"

//小说新书榜单
export const NewRankUrl = "/book/listNewRank"

//小说更新榜单
export const UpdateRankUrl=  "/book/listUpdateRank"