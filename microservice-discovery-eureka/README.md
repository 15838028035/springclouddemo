#使用Spring Cloud Eureka实现高可用服务注册中心

构建一个双节点的服务注册中心集群。

    创建application-peer1.properties,作为peer1服务中心的配置，并将serviceUrl(要注册到服务注册中心的地址)指向peer2

    spring.application.name=eureka-server
    server.port=9003

    #也可以省去下面对hostname的配置，在defaultZone处直接使用IP地址，但是需要配置eureka.instance.prefer-ip-address=true
    eureka.instance.hostname=peer1
    #eureka.client.serviceUrl.defaultZone=http://localhost:9003/eureka/
    eureka.client.serviceUrl.defaultZone=http://peer2:9004/eureka/

    2.创建application-peer2.properties,作为peer2服务中心的配置，并将serviceUrl(要注册到服务注册中心的地址)指向peer1

    spring.application.name=eureka-server
    server.port=9004

    #也可以省去下面对hostname的配置，在defaultZone处直接使用IP地址

    eureka.instance.hostname=peer2
    eureka.client.serviceUrl.defaultZone=http://peer1:9003/eureka/

    3.在/etc/hosts文件中添加对peer1和peer2的转换，让上面配置的host形式的serviceUrl能在本地正确访问到；Windows系统路径为c:\windows\system32\drivers\etc\hosts。

    127.0.0.1 peer1
    127.0.0.1 peer2

    4.在项目的根目录下使用mvn clean package -Dmaven.skip.test=true对项目进行打包，然后使用
    java -jar microservice-discovery-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
    java -jar microservice-discovery-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
            命令分别启动peer1和peer2。

      此时访问peer1的注册中心：http:localhost:9003/
      
      5.修改服务提供方，将其注册到Eureka Server集群中。

    spring.application.name=hello-service
    eureka.client.serviceUrl.defaultZone=http://peer1:9003/eureka,http://peer2:9004/eureka
    
    尝试关闭peer1,peer1已经被关闭，但是hello-service服务仍然可以被访问到，这就实现了服务注册中心的高可用行。
      
 
