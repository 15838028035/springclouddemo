FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /tmp
ADD microservice-api-gateway-0.0.2-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
