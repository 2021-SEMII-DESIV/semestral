FROM maven:3-jdk-8
LABEL MAINTAINER "Erick Agrazal erick@agrazal.com"

# Push the code to the server
COPY . /code
WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
RUN ["mvn", "package"]

EXPOSE 4567
