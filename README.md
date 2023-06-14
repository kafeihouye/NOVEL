
#### 官网

https://www.iotsoft.top 

####后台来自github原作者地址
https://github.com/201206030/novel-plus    
为实现uni-app小程序功能，在此源码的基础上进行重构了一些代码，来满足小程序
####后台开发文档地址
https://docs.xxyopen.com/course/novel/#%E5%AE%89%E8%A3%85%E6%AD%A5%E9%AA%A4


#### 项目介绍 

novel-master 是一个多端（PC、WAP、小程序）阅读，功能完善的原创文学 CMS 系统。由前台门户系统、作家后台管理系统、平台后台管理系统和爬虫管理系统等多个子系统构成，包括小说推荐、作品检索、小说排行、小说阅读、小说评论、会员中心、作家专区等功能，支持自定义多模版、可拓展的多种小说内容存储方式（内置数据库分表存储和 TXT 文本存储）、阅读主题切换、多爬虫源自动采集和更新数据、会员充值、订阅模式、新闻发布和实时统计报表。
小程序端由uni-app框架搭建，由于上线小说小程序需要《互联网出版许可证》或《网络出版服务许可证》这两个证2选1即可上线，所以线上环境目前无法提供
#### 项目结构

```
novel-master -- 父工程
├── novel-common -- 通用模块
├── novel-front -- 前台门户&作家后台管理子系统（可拆分）
├── novel-crawl -- 爬虫管理子系统
├── novel-admin -- 平台后台管理子系统
└── templates -- 前端模版
└── novel-wx-master -- 小程序端
```

#### 技术选型

| 技术                  | 说明                                                         
|---------------------| ---------------------------
| Spring Boot         | Spring 应用快速开发脚手架     
| MyBatis             | 持久层 ORM 框架 
| MyBatis Dynamic SQL | Mybatis 动态 sql
| PageHelper          | MyBatis 分页插件
| MyBatisGenerator    | 持久层代码生成插件
| Sharding-Jdbc       | 代码层分库分表中间件
| JJWT                | JWT 登录支持  
| SpringSecurity      | 安全框架                           
| Shiro               | 安全框架  
| Ehcache             | Java 进程内缓存框架(默认缓存)  
| Redis               | 分布式缓存(缓存替换方案，默认关闭，一行配置开启)                               
| Elasticsearch       | 搜索引擎(搜索增强方案，默认关闭，一行配置开启)                      
| RabbitMQ            | 消息队列(流量削峰，默认关闭，一行配置开启)  
| Aliyun OSS          | 阿里云对象存储服务(图片存储方式之一，一行配置即可切换) 
| FastDFS             | 开源轻量级分布式文件系统(图片存储方式之一，一行配置即可切换)                      
| Redisson            | 实现分布式锁                                       
| Lombok              | 简化对象封装工具                                                                               
| Docker              | 应用容器引擎   
| MySQL               | 数据库服务   
| Thymeleaf           | 模板引擎     
| Layui               | 前端 UI 框架                   
| uni-app               | 小程序框架  
#### 橙色主题模版截图


#### 安装步骤（源码，小白请看其他安装教程）

部分环境（如新版 Mac OS 系统）获取不到主机 IP，需要手动修改 hosts 文件，增加 IP-主机名（通过 hostname 命令查看主机名）的映射。

##### 数据库安装：

1. 安装 MySQL 软件。
2. 修改 MySQL`max_allowed_packet `配置（建议100M）。
3. 新建数据库，设置编码为 utf8mb4。
4. 执行 doc/sql/novel_plus.sql 脚本文件。

##### 爬虫管理系统安装：

1. 修改 novel-common 模块下 application-common-dev.yml（dev环境，默认环境）或 application-common-prod.yml（prod环境，需要在application.yml配置文件中切换）配置文件中的数据库配置。
2. 修改 novel-crawl 模块下 application.yml 文件中的管理员账号密码。
3. 启动程序，打开浏览器，默认 8081端口访问。
4. 选择已有或新增爬虫源（支持自定义爬虫规则），点击`开启`按钮，开始爬取小说数据。

##### 前台小说门户安装（dev环境跳过3、4步骤）：

1. 修改 novel-common 模块下 application-common-dev.yml（dev环境，默认环境）或 application-common-prod.yml（prod环境，需要在application.yml配置文件中切换）配置文件中的数据库配置。

2. 修改 novel-front 模块下 application-website 配置文件中的网站信息。

  ```
  #网站配置
  website:
    #网站名
    name: 南创小说
    #域名
    domain: xiongxyang.gitee.io
    #SEO关键词
    keyword: ${website.name},小说,小说CMS,原创文学系统,开源小说系统,免费小说建站程序
    #SEO描述
    description: ${website.name}是一个多端（PC、WAP）阅读、功能完善的原创文学CMS系统，由前台门户系统、作家后台管理系统、平台后台管理系统、爬虫管理系统等多个子系统构成，支持会员充值、订阅模式、新闻发布和实时统计报表等功能，新书自动入库，老书自动更新。
    #联系QQ
    qq: 862711826
  ```

3. prod 环境下需要修改 novel-front 模块下 application-prod.yml 配置文件中的模版名为你需要使用的模版名（templates文件夹下的模版文件夹名，内置 orange 和 dark 两套模版，prod 环境下才支持多模版）。

  ```
  #模版配置
  templates:
    #模版名
    name: orange
  ```

4. prod 环境下的 jar 包形式部署时，需要复制 templates 文件夹到 jar 文件的相同目录下。   

5. 启动程序，打开浏览器，默认 8080 端口访问。

####小程序运行效果

![登录](https://www.iotsoft.top/img/novel/xcx/%E7%99%BB%E5%BD%95.png)



![授权](https://www.iotsoft.top/img/novel/xcx/%E6%8E%88%E6%9D%83.png)

![首页](https://www.iotsoft.top/img/novel/xcx/%E9%A6%96%E9%A1%B5.png)

![分类](https://www.iotsoft.top/img/novel/xcx/%E5%88%86%E7%B1%BB.png)

![排行](https://www.iotsoft.top/img/novel/xcx/%E6%8E%92%E8%A1%8C.png)

![排行-女生](https://www.iotsoft.top/img/novel/xcx/%E6%8E%92%E8%A1%8C-%E5%A5%B3%E7%94%9F.jpg)



![书架](https://www.iotsoft.top/img/novel/xcx/%E4%B9%A6%E6%9E%B6.png)

![img](https://www.iotsoft.top/img/novel/xcx/1.png)

![img](https://www.iotsoft.top/img/novel/xcx/2.png)

![我的](https://www.iotsoft.top/img/novel/xcx/%E6%88%91%E7%9A%84.png)

###PC网站
![img](https://www.iotsoft.top/img/novel/PC/1.png)

![img](https://www.iotsoft.top/img/novel/PC/2.png)

![img](https://www.iotsoft.top/img/novel/PC/3.png)

![img](https://www.iotsoft.top/img/novel/PC/4.png)


技术文档
-----------------------------------

- 技术官网：  [https://www.iotsoft.top](https://www.iotsoft.top)

- 开发文档：  [主项目文档](https://www.iotsoft.top) | [Vue3文档](https://www.iotsoft.top)

- 新手指南： [快速入门](https://www.iotsoft.top)  |  [视频教程](https://www.iotsoft.top) |   [常见问题 ](https://www.iotsoft.top)  |   [技术支持](https://www.iotsoft.top) |  [1分钟体验低代码](https://my.oschina.net/jeecg/blog/3083313)


- QQ交流群 ： ①92062645
> ` 提醒：【QQ群是自助服务群，建议给帮助您解决问题的同学发送指定红包，表示感谢！】 `

## 赞赏支持

开源项目不易，若此项目能得到你的青睐，那么你可以赞赏支持作者持续开发与维护。

- 服务器的费用也是一笔开销
- 编写更完备的文档教程
- 发布更多前端模版和爬虫规则
- 一杯咖啡

![img](https://www.iotsoft.top/img/novel/SF/wx.jpg)

![img](https://www.iotsoft.top/img/novel/SF/zfb.jpg)

## 免责声明

本项目提供的爬虫工具仅用于采集项目初期的测试数据，请勿用于商业盈利。 用户使用本系统从事任何违法违规的事情，一切后果由用户自行承担，作者不承担任何责任。

