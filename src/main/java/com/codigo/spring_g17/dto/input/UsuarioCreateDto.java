package com.codigo.spring_g17.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioCreateDto {
    private String username;
    private String nombre;
    private String apellido;
    private String dni;

}
