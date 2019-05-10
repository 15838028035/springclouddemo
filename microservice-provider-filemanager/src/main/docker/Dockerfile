FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /tmp
ADD microservice-provider-filemanager-0.0.1-SNAPSHOT.jar microservice-provider-filemanager-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-provider-filemanager-0.0.1-SNAPSHOT.jar"]
