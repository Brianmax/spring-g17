--liquibase formatted sql

--changeset spring-g17:002-create-role-table
CREATE TABLE role
(
    id_role     UUID PRIMARY KEY,
    nombre      VARCHAR(255),
    descripcion VARCHAR(255)
);
--rollback DROP TABLE role;