package com.codigo.spring_g17.dto.ouput;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloCreateResponse {
    private UUID idArticulo;
    private String titulo;
    private String contenido;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String nombreUsuario;
}
