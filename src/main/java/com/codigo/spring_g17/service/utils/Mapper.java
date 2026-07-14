package com.codigo.spring_g17.service.utils;

import com.codigo.spring_g17.dto.input.ArticuloCreateDto;
import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.ArticuloCreateResponse;
import com.codigo.spring_g17.dto.ouput.ReniecResponseApi;
import com.codigo.spring_g17.dto.ouput.UsuarioResponse;
import com.codigo.spring_g17.entity.ArticuloEntity;
import com.codigo.spring_g17.entity.RoleEntity;
import com.codigo.spring_g17.entity.UsuarioEntity;

import java.util.ArrayList;

public class Mapper {
    public static UsuarioResponse fromUsuarioEntity(UsuarioEntity usuarioEntity) {
        ArrayList<String> roles = new ArrayList<>();

        for(RoleEntity role: usuarioEntity.getRoles()) {
            roles.add(role.getNombre());
        }
        return new UsuarioResponse(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getUsername(),
                usuarioEntity.getNombre(),
                usuarioEntity.getApellido(),
                usuarioEntity.getDni(),
                usuarioEntity.isEstado(),
                roles
        );
    }

    public static UsuarioEntity fromUsuarioCreateDto(ReniecResponseApi responseReniec) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(responseReniec.getFirstName());
        usuarioEntity.setApellido(responseReniec.getFirstLastName());
        usuarioEntity.setUsername(responseReniec.getDocumentNumber());
        usuarioEntity.setDni(responseReniec.getDocumentNumber());
        return usuarioEntity;
    }

    public static ArticuloEntity fromArticuloCreateDto(ArticuloCreateDto articuloCreateDto) {
        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setTitulo(articuloCreateDto.getTitulo());
        articuloEntity.setContenido(articuloCreateDto.getContenido());
        return articuloEntity;
    }

    public static ArticuloCreateResponse fromArticuloEntity(ArticuloEntity articuloEntity) {
        return new ArticuloCreateResponse(
                articuloEntity.getIdArticulo(),
                articuloEntity.getTitulo(),
                articuloEntity.getContenido(),
                articuloEntity.getFechaCreacion(),
                articuloEntity.getFechaActualizacion(),
                articuloEntity.getUsuarioEntity().getNombre()
        );
    }
}
