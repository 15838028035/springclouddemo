FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-hystrix-dashboard-0.0.1-SNAPSHOT.jar"]
