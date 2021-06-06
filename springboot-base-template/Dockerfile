FROM openjdk:8
WORKDIR /usr/jar
ADD target/spring-boot-basetemplate.jar .
VOLUME /tmp
EXPOSE 8085
ENTRYPOINT ["java", "-jar","spring-boot-basetemplate.jar"]