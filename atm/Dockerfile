FROM java:8-jdk-alpine
MAINTAINER Shmuel Halbfinger
COPY ./target/atm-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "atm-1.0-SNAPSHOT.jar"]