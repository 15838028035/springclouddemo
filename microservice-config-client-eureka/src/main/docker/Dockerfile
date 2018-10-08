FROM java:8
VOLUME /tmp
ADD microservice-config-client-eureka-0.0.1-SNAPSHOT.jar microservice-config-client-eureka-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /microservice-config-client-eureka-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-config-client-eureka-0.0.1-SNAPSHOT.jar"]
