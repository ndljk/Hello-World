FROM openjdk:8
ADD target/hello-world-translation.jar hello-world-translation.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","hello-world-translation.jar"]