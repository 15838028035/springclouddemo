# 分布式配置中心访问网址
      在application.properties中有个git.uri的配置，目前配置的是http://192.168.96.89:3000/zhangpeng/springclouddemo.git
      获取git上的资源信息遵循如下规则：
      /{application}/{profile}[/{label}]
      /{application}-{profile}.yml
      /{label}/{application}-{profile}.yml
      /{application}-{profile}.properties
      /{label}/{application}-{profile}.properties
     
      例如本例：可使用以下路径来访问microservice-config-client-dev.properties：
      http://localhost:9004/microservice-config-client-dev.properties
      http://localhost:9004/microservice-config-client/dev
 
# 分布式配置中心动态刷新
 
## 1.修改microservice-config-server-eureka/src/main/resources/application.properties 中的配置

    spring.rabbitmq.host=127.0.0.1
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=root
    spring.rabbitmq.password=root
    
## 2. 启动工程， 修改分布式配置文件信息,执行刷新
    http://127.0.0.1:9004/bus/refresh
    
## 3. 观察配置中心客户端的值是否改变
     http://127.0.0.1:8051/hello
    
    
# 非对称加解密

    如果使用非对称加解密的方式，我们的安全性将会得到进一步的提高。使用非对称加密的话需要我们先生成密钥对，生成密钥对可以直接使用jdk中自带的keytool工具，方式如下：
    
    keytool -genkeypair -alias config-server -keyalg RSA -keystore config-server.keystore
    
    
    执行成功之后，会在命令执行目录下生成一个名为config-server.keystore的文件，将该文件拷贝到config-server的src\main\resources目录下，然后做如下配置：
    
    encrypt.key-store.location=config-server.keystore
    encrypt.key-store.alias=config-server
    encrypt.key-store.password=111111
    encrypt.key-store.secret=111111
      
 
