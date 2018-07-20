
[![travis-ci](https://travis-ci.org/15838028035/springclouddemo.svg?branch=master)]
(https://travis-ci.org/15838028035/springclouddemo.svg?branch=master)


[![Quality Gate](http://192.168.96.88:9000/dashboard?id=com.zhongkexinli.cloud%3Aspring-cloud-microservice-demo&metric=alert_status)](http://192.168.96.88:9000/dashboard?id=com.zhongkexinli.cloud%3Aspring-cloud-microservice-demo)

# 项目简介
内容主要包含：

| 微服务角色                 | 对应的技术选型                              |
| --------------------- | ------------------------------------ |
| 注册中心(Register Server) | Eureka                               |
| 服务提供者                 | spring mvc、mybatis 、mysql 等       |
| API Gateway           | Zuul                                 |


# 准备

## 环境准备：

| 工具    | 版本或描述                |
| ----- | -------------------- |
| JDK   | 1.8                  |
| IDE   | STS 或者 IntelliJ IDEA |
| Maven | 3.x                  |

## 模块介绍：
| 项目名称                                     | 描述                                                                                                                     |
| -------------------| ---------------------------------------- |
| microservice-common-model            | 公共实体对象 |
| microservice-provider-dal            | 公共dao和service层 |
| microservice-discovery-eureka        | 注册中心              |
| microservice-config-server-eureka    | 可配置的注册中心服务端  demo            |
| microservice-config-client-eureka    | 可配置的注册中心客户端demo              |
| microservice-hystrix-turbine         |Turbine集群监控            |
| microservice-hystrix-dashboard       | 服务断容面板              |
| microservice-provider-secrity       | 服务提供者          |
| microservice-api-gateway                 | API Gateway  
| microservice-front-app                   | 网站前台静态页面, 服务消费客户端     |
| microservice-provider-kafka              | kafka消息组件demo     |


## 主机规划：

| 项目名称                                     | 端口   | 描述                     | URL             |
| ---------------------------------------- | ---- | ---------------------- | --------------- |
| microservice-api-gateway                 | 8050 | API Gateway            |                 |
| microservice-front-app                   | 8022 | 网站前台静态页面, 服务消费客户端   |                 |
| microservice-discovery-eureka            | 9003 | 注册中心                                                    |                 |
| microservice-provider-secrity            | 8002 | 服务提供者                                                |                  |
| microservice-provider-secrity            | 8003 | kafka消息组件demo        |                  |

## 快速上手

 1. 修改microservice-provider-dal项目中application.properties数据库的地址,账号密码
 <pre>
     <code>
      #mysql database config
     spring.datasource.url=jdbc:mysql://127.0.0.1:3306/test_db?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false
     #use jasypt to encrypt username/password
     spring.datasource.username=ENC(HTdPvf6oI3QOJJFq7Ht0qw==)
     # root
     spring.datasource.password=ENC(HTdPvf6oI3QOJJFq7Ht0qw==)
     </code>
 </pre>

执行springclouddemo\scripts\test_db.sql,创建测试表结构


     启  动microservice-discovery-eureka,
     microservice-provider-secrity,
     microservice-front-app,
     microservice-api-gateway
     
    front-app接口访问地址:
         http://127.0.0.1:8022/swagger-ui.html
    microservice-provider-secrity接口访问地址:
        http://127.0.0.1:8002/swagger-ui.html     
  

# 代码贡献
 1. fork代码
 2. 建立分支
 3. 提交代码,pull request
 4. 更新代码

# 分支管理
 1. master分支，禁止在上面开发
 2. develop分支 开发分支
 3. bugfix分支  线上问题紧急修复分支

# 代码规范
 提交代码前，尽量使用工程中提供的checkstyle.xml对代码风格进行检查
 


     
