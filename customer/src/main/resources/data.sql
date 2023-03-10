CREATE TABLE IF NOT EXISTS customer (
    id UUID                 NOT NULL PRIMARY KEY,
    email VARCHAR(200)      NOT NULL UNIQUE,
    firstName VARCHAR(100)   NOT NULL,
    lastName VARCHAR(100)   NOT NULL
);
--CREATE DATABASE IF NOT EXISTS dealershipDB;
