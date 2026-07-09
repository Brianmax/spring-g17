--liquibase formatted sql

--changeset spring-g17:004-create-usuario-role-table
CREATE TABLE usuario_role
(
    id_usuario_fk UUID NOT NULL,
    id_role_fk    UUID NOT NULL,
    CONSTRAINT pk_usuario_role PRIMARY KEY (id_usuario_fk, id_role_fk),
    CONSTRAINT fk_usuario_role_usuario FOREIGN KEY (id_usuario_fk) REFERENCES usuario (id_usuario),
    CONSTRAINT fk_usuario_role_role FOREIGN KEY (id_role_fk) REFERENCES role (id_role)
);
--rollback DROP TABLE usuario_role;