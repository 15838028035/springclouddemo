FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /tmp
ADD api-gateway-microservice-0.0.2-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
