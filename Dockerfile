 FROM openjdk:11
 MAINTAINER ecosystem
 RUN mkdir /app
 WORKDIR /app
 COPY /target/createTaskApplication-0.0.1-SNAPSHOT.jar createTaskApplication.jar
 COPY /target/classes/application.properties application.properties
 RUN bash -c 'mkdir -p src/main/resources'
 COPY /target/classes/BA.p12 src/main/resources/BA.p12
 CMD java -jar createTaskApplication.jar
