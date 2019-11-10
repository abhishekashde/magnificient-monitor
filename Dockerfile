FROM openjdk:8-jdk-alpine
RUN mkdir /usr/app
COPY ./target/magnificent-monitor-0.0.1-SNAPSHOT.jar /usr/app
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT ["java","-jar","magnificent-monitor-0.0.1-SNAPSHOT.jar"]
