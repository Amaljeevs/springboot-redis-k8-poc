FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} psh-redis-k8-poc-service.jar
ENTRYPOINT ["java","-jar","/psh-redis-k8-poc-service.jar"]