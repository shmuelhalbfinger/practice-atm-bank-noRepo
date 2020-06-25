FROM java:8-jdk-alpine
COPY ./target/bank-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "bank-1.0-SNAPSHOT.jar"]