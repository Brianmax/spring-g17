package com.codigo.spring_g17.service;

import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioResponse;
import com.codigo.spring_g17.entity.RoleEntity;
import com.codigo.spring_g17.entity.UsuarioEntity;
import com.codigo.spring_g17.repository.RoleRepository;
import com.codigo.spring_g17.repository.UsuarioRepository;
import com.codigo.spring_g17.service.utils.Mapper;
import com.codigo.spring_g17.service.utils.PasswordGenerator;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    public UsuarioResponse createUsuario(UsuarioCreateDto usuarioCreateDto) {
        String dni = usuarioCreateDto.getDni();
        // generar contrasenia para el usuario nuevo
        String password = PasswordGenerator.generatePassword(
                10,
                true,
                true,
                true,
                true);

        UsuarioEntity usuarioEntity = Mapper.fromUsuarioCreateDto(usuarioCreateDto);
        usuarioEntity.setPassword(password);
        usuarioRepository.save(usuarioEntity);
        return Mapper.fromUsuarioEntity(usuarioEntity);
    }

    public UsuarioResponse findUsuarioById(UUID id) {
        Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isEmpty()) {
            return null;
        }
        UsuarioEntity usuarioEntity = optionalUsuario.get();
        return Mapper.fromUsuarioEntity(usuarioEntity);
    }

    public UsuarioResponse agregarRoleUsuario(String role, UUID idUsuario) {
        Optional<RoleEntity> roleOptional = roleRepository.findByNombe(role);
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);
        if(roleOptional.isEmpty() || usuarioOptional.isEmpty()) {
            return null;
        }

        UsuarioEntity usuarioEntity = usuarioOptional.get();
        RoleEntity roleEntity = roleOptional.get();
        Set<RoleEntity> rolesCollection = usuarioEntity.getRoles();
        rolesCollection.add(roleEntity);

        usuarioRepository.save(usuarioEntity);
        return Mapper.fromUsuarioEntity(usuarioEntity);
    }
}
