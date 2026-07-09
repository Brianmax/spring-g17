package com.codigo.spring_g17.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "articulo", schema = "articles")
@Getter
@Setter
public class ArticuloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_articulo")
    private UUID idArticulo;
    private String titulo;
    private String contenido;
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk")
    private UsuarioEntity usuarioEntity;
}

// crear la tabla comentario