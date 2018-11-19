FROM maven:3-jdk-8-alpine
VOLUME /tmp
ADD microservice-provider-kafka-0.0.1-SNAPSHOT.jar microservice-provider-kafka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-provider-kafka-0.0.1-SNAPSHOT.jar"]
