FROM maven:3-jdk-8-alpine
VOLUME /tmp
ADD microservice-hystrix-turbine-0.0.1-SNAPSHOT.jar microservice-hystrix-turbine-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /microservice-hystrix-turbine-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-hystrix-turbine-0.0.1-SNAPSHOT.jar"]
