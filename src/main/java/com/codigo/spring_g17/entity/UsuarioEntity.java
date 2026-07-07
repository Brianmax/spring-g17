package com.codigo.spring_g17.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private UUID idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private boolean estado = true;
    private String dni;
    @Column(name = "fecha_creacion")
    private String fechaCreacion = new Date(System.currentTimeMillis()).toString();
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @Column(name = "numero_articulos", columnDefinition = "INTEGER DEFAULT 0")
    private Integer numeroArticulos = 0;
    @Column(name = "numero_comentarios")
    private Integer numeroComentarios = 0;

    @ManyToMany
    @JoinTable(
            name = "usuario_role",
            joinColumns = @JoinColumn(name = "id_usuario_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_role_fk")
    )
    private Set<RoleEntity> roles = new HashSet<>();

}
