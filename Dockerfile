FROM openjdk:12-jdk-alpine

ENV MARVEL_API_PORT=80
ENV MARVEL_API_DB_HOST=mongo
ENV MARVEL_API_DB_PORT=27017
ENV MARVEL_API_DB_NAME=marvel
ENV MARVEL_API_REDIS_HOST=redis
ENV MARVEL_API_REDIS_PORT=6379

RUN mkdir /app

WORKDIR /app

COPY ./target/marvel-mock-api.jar /app

EXPOSE $MARVEL_API_PORT

CMD java -jar marvel-mock-api.jar
