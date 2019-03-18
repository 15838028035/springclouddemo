FROM openjdk:8u181-jre-alpine3.8
VOLUME /tmp
ADD microservice-hystrix-dashboard-0.0.2-SNAPSHOT.jar microservice-hystrix-dashboard-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-hystrix-dashboard-0.0.2-SNAPSHOT.jar"]
