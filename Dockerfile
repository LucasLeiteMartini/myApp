FROM ubuntu:22.04

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y curl zip unzip

WORKDIR /myApp

COPY . /myApp

RUN ./installer.sh

EXPOSE 8080

ENV JAVA_HOME="/root/.sdkman/candidates/java/current"

CMD ["./gradlew","clean","bootRun"]