package com.codigo.spring_g17.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class ComentarioCreatDto {
    private String contenido;
    private UUID usuarioId;
    private UUID articuloId;
}
