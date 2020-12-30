FROM openjdk:latest

ADD target/pokkar-api-0.0.1-SNAPSHOT.jar pokkar-api.jar

ENTRYPOINT [ "java","-jar","pokkar-api.jar" ]
EXPOSE 8080