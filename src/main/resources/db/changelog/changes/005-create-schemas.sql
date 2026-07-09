--liquibase formatted sql

--changeset spring-g17:005-move-tables-to-schemas
CREATE SCHEMA IF NOT EXISTS users;
CREATE SCHEMA IF NOT EXISTS articles;