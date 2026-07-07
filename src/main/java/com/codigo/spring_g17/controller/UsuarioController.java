package com.codigo.spring_g17.controller;

import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioCreateResponse;
import com.codigo.spring_g17.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioCreateResponse> crearUsuario(@Valid @RequestBody UsuarioCreateDto usuarioCreateDto) {
        UsuarioCreateResponse userResponse = usuarioService.createUsuario(usuarioCreateDto);
        if(userResponse == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCreateResponse> findById(@PathVariable UUID id) {
        UsuarioCreateResponse userResponse = usuarioService.findUsuarioById(id);
        if(userResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    // retornar un usuario por su id
}
