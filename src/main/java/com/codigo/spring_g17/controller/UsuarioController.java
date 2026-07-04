package com.codigo.spring_g17.controller;

import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioCreateResponse;
import com.codigo.spring_g17.entity.UsuarioEntity;
import com.codigo.spring_g17.repository.UsuarioRepository;
import com.codigo.spring_g17.utils.PasswordGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/save")
    public UsuarioCreateResponse crearUsuario(@RequestBody UsuarioCreateDto usuarioCreateDto) {
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
}
