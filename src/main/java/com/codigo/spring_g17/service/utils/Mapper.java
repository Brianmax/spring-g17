package com.codigo.spring_g17.service.utils;

import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioResponse;
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

    public static UsuarioEntity fromUsuarioCreateDto(UsuarioCreateDto usuarioCreateDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsername(usuarioCreateDto.getUsername());
        usuarioEntity.setNombre(usuarioCreateDto.getNombre());
        usuarioEntity.setApellido(usuarioCreateDto.getApellido());
        usuarioEntity.setDni(usuarioCreateDto.getDni());
        return usuarioEntity;
    }
}
