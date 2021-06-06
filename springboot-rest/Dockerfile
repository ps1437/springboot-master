FROM openjdk:8
WORKDIR /usr/jar
ADD target/docker-spring-boot-rest.jar .
VOLUME /tmp
EXPOSE 8085
ENTRYPOINT ["java", "-jar","docker-spring-boot-rest.jar"]