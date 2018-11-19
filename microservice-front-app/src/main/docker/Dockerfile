FROM maven:3-jdk-8-alpine
VOLUME /tmp
ADD microservice-front-app-0.0.1-SNAPSHOT.jar microservice-front-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-front-app-0.0.1-SNAPSHOT.jar"]
