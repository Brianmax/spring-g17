package com.codigo.spring_g17.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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

}
