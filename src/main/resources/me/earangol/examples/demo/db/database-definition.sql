CREATE DATABASE spring_angular_demo;

\c spring_angular_demo;

CREATE TABLE People (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(65) NOT NULL,
    lastName  VARCHAR(64) NOT NULL);

INSERT INTO People(firstName, lastName) VALUES (‘John’, ‘Smith’), (‘Charles’, ‘Stroup’), (‘Cristopher’, ‘Jacobs’);