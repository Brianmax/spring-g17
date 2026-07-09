create table if not exists comentario
(
    id_comentario       uuid primary key,
    contenido           varchar not null,
    fecha_creacion      date default now(),
    fecha_actualizacion date,
    id_articulo_fk      uuid not null,
    id_usuario_fk       uuid not null,

    foreign key (id_articulo_fk) references articulo (id_articulo),
    foreign key (id_usuario_fk) references usuario (id_usuario)
);