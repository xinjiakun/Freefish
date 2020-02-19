# Elasticsearch

Elasticsearch是一个基于Apache Lucene(TM)的开源搜索引擎。无论在开源还是专有领域，Lucene可以被认为是迄今为止最先进、性能最好的、功能最全的搜索引擎库。
但是，Lucene只是一个库。想要使用它，你必须使用Java来作为开发语言并将其直接集成到你的应用中，更糟糕的是，Lucene非常复杂，你需要深入了解检索的相关知识来理解它是如何工作的。

Elasticsearch也使用Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文搜索变得简单。
不过，Elasticsearch不仅仅是Lucene和全文搜索，我们还能这样去描述它：

- 分布式的实时文件存储，每个字段都被索引并可被搜索
- 分布式的实时分析搜索引擎
- 可以扩展到上百台服务器，处理PB级结构化或非结构化数据

[官方网址](https://www.elastic.co/cn/)

[官方Github](https://github.com/elastic/elasticsearch)

[官方中文权威指南](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)

[官方Java API文档](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)

### 推荐学习资源

- [Elasticsearch Java API 手册](https://es.quanke.name/)

- [Elasticsearch权威指南](http://www.learnes.net/index.html)

### 安装环境

- Windows10
- 依赖 Java 8+

### 安装Elasticsearch

- [官方下载地址](https://www.elastic.co/downloads/elasticsearch)
- [华为云镜像下载地址](https://mirrors.huaweicloud.com/elasticsearch/)(推荐)
- 解压安装包 
- [安装步骤](https://www.jianshu.com/p/518b1273f4c1)



### 踩坑解决错误

1. 服务器客户端版本需完全匹配
	以我为例: 
	客户端版本：spring-boot-starter-data-elasticsearch:2.1.4.RELEASE(org.elasticsearch.client:transport:6.4.3)
	服务器版本：elasticsearch-6.5.4

### 测试是否启动成功

访问 http://127.0.0.1:9200

### 插件Elasticsearch-head安装
-es可视化页面  方便管理

[Head-GitHub官网](https://github.com/mobz/elasticsearch-head)

- 依赖：Git Node.js
- 官网安装教程
```
git clone git://github.com/mobz/elasticsearch-head.git
cd elasticsearch-head
npm install
npm run start


```

- 打开浏览器输入访问 http://127.0.0.1:9100


### 插件logstash-input-jdbc安装
-监听mysql,同步mysql数据到es中,insert和update的时候也会同步

[华为云镜像下载地址](https://mirrors.huaweicloud.com/logstash/)(版本和elasticsearch保持一致)


- 安装教程

 cd D:\logstash-6.5.4\bin
 
 logstash-plugin.bat install logstash-input-jdbc
 
 新建logstash.conf
 [logstash.conf具体信息](https://github.com/xinjiakun/Freefish/blob/master/logstash.conf)
 
 新建jdbc.sql (定期执行脚本 将mysql数据导入es)
 [logstash.conf具体信息](https://github.com/xinjiakun/Freefish/blob/master/jdbc.sql)
 修改成自己的数据库连接信息 本地驱动路径 jdbc.sql路径 es 索引 类型 id(对应mysql数据库)
 (注意:windows下的文本编码需要为ANSI，否则运行将会出错, 另外注意是"hosts", 我这边如果写成"host"会出错，另外下面长长的一段连接后面是我加上去的，如果不加上去，运行的时候会报时间什么的错误，mysql驱动要跟你的mysql数据库版本对应起来，否则会出错)
 
 logstash.bat -f logstash.conf
 
