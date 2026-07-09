--liquibase formatted sql

--changeset spring-g17:001-create-usuario-table
CREATE TABLE usuario
(
    id_usuario          UUID PRIMARY KEY,
    username            VARCHAR(255),
    password            VARCHAR(255),
    nombre              VARCHAR(255),
    apellido            VARCHAR(255),
    estado              BOOLEAN DEFAULT TRUE,
    dni                 VARCHAR(255),
    fecha_creacion      VARCHAR(255),
    fecha_actualizacion DATE,
    numero_articulos    INTEGER DEFAULT 0,
    numero_comentarios  INTEGER
);
--rollback DROP TABLE usuario;