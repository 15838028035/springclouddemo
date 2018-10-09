FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD microservice-config-server-eureka-0.0.1-SNAPSHOT.jar  microservice-config-server-eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-config-server-eureka-0.0.1-SNAPSHOT.jar"]
