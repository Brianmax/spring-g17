package com.codigo.spring_g17.service;

import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioCreateResponse;
import com.codigo.spring_g17.entity.UsuarioEntity;
import com.codigo.spring_g17.repository.UsuarioRepository;
import com.codigo.spring_g17.service.utils.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioCreateResponse createUsuario(UsuarioCreateDto usuarioCreateDto) {
        String dni = usuarioCreateDto.getDni();
        if(dni.length() != 8) {
            return null;
        }
        // generar contrasenia para el usuario nuevo
        String password = PasswordGenerator.generatePassword(
                10,
                true,
                true,
                true,
                true);

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsername(usuarioCreateDto.getUsername());
        usuarioEntity.setPassword(password);
        usuarioEntity.setNombre(usuarioCreateDto.getNombre());
        usuarioEntity.setApellido(usuarioCreateDto.getApellido());
        usuarioEntity.setDni(dni);

        usuarioRepository.save(usuarioEntity);

        return new UsuarioCreateResponse(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getUsername(),
                usuarioEntity.getNombre(),
                usuarioEntity.getApellido(),
                usuarioEntity.getDni(),
                usuarioEntity.isEstado()
        );
    }

    public UsuarioCreateResponse findUsuarioById(UUID id) {
        Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isEmpty()) {
            return null;
        }
        UsuarioEntity usuarioEntity = optionalUsuario.get();
        return new UsuarioCreateResponse(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getUsername(),
                usuarioEntity.getNombre(),
                usuarioEntity.getApellido(),
                usuarioEntity.getDni(),
                usuarioEntity.isEstado()
        );
    }
}
