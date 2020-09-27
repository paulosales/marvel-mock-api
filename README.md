# marvel-mock-api - [![Build Status](https://travis-ci.com/paulosales/marvel-mock-api.svg?branch=master)](https://travis-ci.com/paulosales/marvel-mock-api) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=paulosales_marvel-mock-api&metric=alert_status)](https://sonarcloud.io/dashboard?id=paulosales_marvel-mock-api) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=paulosales_marvel-mock-api&metric=coverage)](https://sonarcloud.io/dashboard?id=paulosales_marvel-mock-api) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=paulosales_marvel-mock-api&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=paulosales_marvel-mock-api)

> A Marvel mocking API

## Install and run

The marvel mocking API is distributed as a docker image, so you can build and run a container to deploy and test it.

The application image can be found in https://hub.docker.com/r/prsales/marvel-mock-api

### Configuration

The application can be configured through OS environments variables. Here we have a table with all environment variable that you can use to customize the application:

| Environment variable    | Default value |
|:----------------------|--------------:|
| MARVEL_API_DB_HOST    | mongo         |
| MARVEL_API_DB_PORT    | 27017         |
| MARVEL_API_DB_NAME    | marvel        |
| MARVEL_API_REDIS_HOST | redis         |
| MARVEL_API_REDIS_PORT | 6379          |

### Dependencies

To run the API application properly you must create the dependencies containers. The dependencies are the database container(mongodb) and a cache server(redis).

You can create a `docker-composer.yml` file with the content below and run `docker-compose up -d` to run the API and its dependencies.

```yml
volumes:
  data_marvel:

version: '2'
services:
  api:
    image: prsales/marvel-mock-api:latest
    environment:
      MARVEL_API_DB_HOST: mongo
      MARVEL_API_DB_PORT: 27017
      MARVEL_API_DB_NAME: marvel
      MARVEL_API_REDIS_HOST: redis
      MARVEL_API_REDIS_PORT: 6379
    ports:
      - 8082:80
    depends_on:
      - mongo
      - redis

  redis:
    image: redis:6.0.8-alpine

  mongo:
    image: mongo:4.4.1-bionic
    restart: always
    volumes:
      - data_marvel:/data/db
      - ./scripts/init.db.js:/docker-entrypoint-initdb.d/init.db.js #Download the 'init.db.js' file at the link below
    environment:
      MONGO_INITDB_DATABASE: marvel
```

### Database initialization script

The database data initialization script can be downloaded at [init.db.js](https://raw.githubusercontent.com/paulosales/marvel-mock-api/master/docker/scripts/init.db.js).

### Redis configuration (optional)

Optionally you can config Redis Cache with this configuration file: [redis.conf](https://raw.githubusercontent.com/paulosales/marvel-mock-api/master/docker/config/redis.conf).

Just add the config file into `docker-compose.yml` configuration as a volume:

```yml
volumes:
  - ./docker/config/redis.conf:/usr/local/etc/redis/redis.conf
```

## Usage

The API swagger-ui documentation can be founded at http://localhost:8082/v1/swagger-ui.html/

