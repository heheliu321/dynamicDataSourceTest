# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### mysql主从结构
* 192.168.13.129:3306（master）和192.168.13.130:3306(slaver)是主从架构，配置的详细步骤参看https://blog.csdn.net/nmjhehe/article/details/102181648
* 使用AbstractRoutingDataSource整合了192.168.13.129的master数据源和192.168.13.130的slaver数据源
* 使用aop实现读写分离时机