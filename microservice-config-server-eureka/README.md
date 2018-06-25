# 分布式配置中心动态刷新

## 1.修改microservice-config-server-eureka/src/main/resources/application.properties 中的配置

    spring.rabbitmq.host=127.0.0.1
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=root
    spring.rabbitmq.password=root
    
## 2. 启动工程， 修改分布式配置文件信息,执行刷新
    http://127.0.0.1:9004/bus/refresh
      
 
