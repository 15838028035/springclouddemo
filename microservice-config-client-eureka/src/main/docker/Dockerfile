FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /tmp
ADD microservice-config-client-eureka-0.0.2-SNAPSHOT.jar microservice-config-client-eureka-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-config-client-eureka-0.0.2-SNAPSHOT.jar"]
