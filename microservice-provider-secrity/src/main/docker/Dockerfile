FROM openjdk:8u181-jre-alpine3.8
VOLUME /tmp
ADD microservice-provider-secrity-0.0.2-SNAPSHOT.jar microservice-provider-secrity-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-provider-secrity-0.0.2-SNAPSHOT.jar"]
