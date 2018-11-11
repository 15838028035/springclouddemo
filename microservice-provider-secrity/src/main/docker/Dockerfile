FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD microservice-provider-secrity-0.0.1-SNAPSHOT.jar microservice-provider-secrity-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-provider-secrity-0.0.1-SNAPSHOT.jar"]
