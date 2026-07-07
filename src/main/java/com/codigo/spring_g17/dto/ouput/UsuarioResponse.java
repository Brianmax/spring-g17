package com.codigo.spring_g17.dto.ouput;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private UUID usuarioId;
    private String username;
    private String nombre;
    private String apellido;
    private String dni;
    private boolean estado;
    private ArrayList<String> roles;
}
