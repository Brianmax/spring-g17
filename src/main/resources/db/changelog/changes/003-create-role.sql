--liquibase formatted sql

--changeset spring-g17:003-create-articulo-table
CREATE TABLE articulo
(
    id_articulo         UUID PRIMARY KEY,
    titulo              VARCHAR(255),
    contenido           VARCHAR(255),
    fecha_creacion      VARCHAR(255),
    fecha_actualizacion VARCHAR(255),
    id_usuario_fk       UUID,
    CONSTRAINT fk_articulo_usuario FOREIGN KEY (id_usuario_fk) REFERENCES usuario (id_usuario)
);
--rollback DROP TABLE articulo;