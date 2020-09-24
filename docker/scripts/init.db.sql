SELECT 'CREATE DATABASE marvel'
WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'marvel')\gexec

\c marvel

CREATE TYPE Url As (
  type VARCHAR(100),
  url VARCHAR(500)
);

CREATE TYPE Image As (
  path VARCHAR(255),
  extension VARCHAR(10)
);

CREATE TYPE TextObject As (
  type VARCHAR(50),
  language VARCHAR(5),
  text TEXT
);

CREATE TYPE 

CREATE SEQUENCE SQ_CHARACTER INCREMENT 1 START 1 MINVALUE 1;

CREATE TABLE CHARACTERS (
  id BIGINT NOT NULL DEFAULT nextval('SQ_CHARACTER') PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  description VARCHAR(200) NOT NULL,
  modified TIMESTAMP NOT NULL,
  resourceURI VARCHAR(200) NOT NULL,
  urls Url[] NULL,
  thumbnail Image NULL
);

CREATE SEQUENCE SQ_COMIC INCREMENT 1 START 1 MINVALUE 1;

CREATE TABLE COMICS (
  id BIGINT NOT NULL DEFAULT nextval('SQ_CHARACTER') PRIMARY KEY,
  idCharacter BIGINT NOT NULL,
  digitalId BIGINT NOT NULL DEFAULT 0,
  title VARCHAR(200) NOT NULL,
  issueNumber DECIMAL(10,2),
  variantDescription TEXT,
  description TEXT,
  modified TIMESTAMP,
  isbn VARCHAR(20),
  upc VARCHAR(20),
  diamondCode VARCHAR(10),
  ean VARCHAR(20),
  issn VARCHAR(20),
  format VARCHAR(50),
  pageCount INT,
  textObjects TextObject[],
  resourceURI VARCHAR(500),
  urls Url[],
  series
);