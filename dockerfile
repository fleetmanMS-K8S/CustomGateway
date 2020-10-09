FROM openjdk:8-jdk-alpine
COPY target/customgateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","gateway.jar"]