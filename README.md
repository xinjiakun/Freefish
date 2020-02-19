# freefish
> 作者本科毕业设计项目 



### 前台页面为基于Vue的独立项目 请跳转至 [freefish-vue](https://github.com/xinjiakun/freefish-vue.git) 项目仓库查看

### 校园二手电商商城
- [x] 前台系统：用户可以在前台系统中进行注册、登录、浏览商品、首页、下单等操作
- [x] 会员系统：用户可以在该系统中查询已下的订单、管理订单、我的优惠券等信息
- [x] 订单系统：提供下单、查询订单、修改订单状态、定时处理订单
- [x] 搜索系统：提供商品的搜索功能

- [极验验证码移除文档](https://github.com/Exrick/xmall/wiki/%E6%9E%81%E9%AA%8C%E7%A7%BB%E9%99%A4%E6%96%87%E6%A1%A3)

![](https://i.loli.net/2018/07/22/5b5461099039e.jpg "后台首页")

![](https://i.loli.net/2018/07/22/5b546125886ca.jpg "商品管理")

![](https://i.loli.net/2018/07/22/5b54613bc866f.jpg "管理员编辑")

![](https://i.loli.net/2018/07/22/5b54615b95788.jpg "前台首页")

![](https://i.loli.net/2018/07/22/5b5461756b2b0.jpg "ES分词搜索")

### 项目架构及功能模块图

![](https://i.loli.net/2018/07/22/5b5461926969b.png)

![](https://i.loli.net/2018/07/22/5b5461aa2fdee.jpg)

![](https://i.loli.net/2018/07/22/5b5461c54cb55.jpg)

### 前端所用技术
- 前台页面
    - 详情请跳转至 [freefish-vue](https://github.com/xinjiakun/freefish-vue) 项目仓库
    - Vue2 + Vuex + Vue Router + Element UI + ES6 + webpack + axios + Node.js
    
### 后端所用技术
- Spring
- SpringMVC
- MyBatis
- MySQL
- Redis：缓存
- Elasticsearch：基于Lucene分布式搜索引擎
- Swagger2：Api文档生成
- Docker
- Tomcat
- Maven

### 文件说明
- `freefish` 文件夹提供部分依赖与sql文件
    - freefish.sql：数据库文件
### 本地开发运行部署
- 下载zip直接解压或安装git后执行克隆命令 `git clone https://github.com/xinjiakun/Freefish.git`
- 安装各中间件并启动：[Redis](https://www.runoob.com/redis/redis-install.html)、[Elasticsearch](https://github.com/xinjiakun/Freefish/blob/master/Elasticsearch.md)
- [Maven安装和在IDEA中配置](https://github.com/Exrick/xmall/blob/master/study/Maven.md)
- 使用IDEA, `File-Open` 直接打开freefish项目，点击右下角 `Import Changes` 等待安装完依赖即可
- MySQL数据库新建 `freefish` 数据库，运行sql文件
-springboot配置FreeFishApplication启动类  一键启动
- 前端项目接口默认端口8080 前台页面请启动基于Vue的 [freefish-vue](https://github.com/xinjiakun/freefish-vue) 项目，并修改其接口配置
### 相关技术点说明
- es插件logstash-input-jdbc 同步mysql数据到es
    - 详见 [elasticsearch](https://github.com/xinjiakun/Freefish/Elasticsearch.md)
    - mysql对应实体类需对应 注解es索引、类型，示例：

    ``` 
		@Document(indexName = "freefish" , type = "tbGoodPO")
		public class TbGoodPO implements Serializable {
    ```



