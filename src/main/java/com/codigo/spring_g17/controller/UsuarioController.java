package com.codigo.spring_g17.controller;

import com.codigo.spring_g17.dto.input.ChangePasswordDto;
import com.codigo.spring_g17.dto.input.UsuarioCreateDto;
import com.codigo.spring_g17.dto.ouput.UsuarioResponse;
import com.codigo.spring_g17.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestParam String dni) {
        UsuarioResponse userResponse = usuarioService.createUsuario(dni);
        if(userResponse == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable UUID id) {
        UsuarioResponse userResponse = usuarioService.findUsuarioById(id);
        if(userResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/role")
    public ResponseEntity<UsuarioResponse> addRoleToUser(
            @RequestParam String role, @RequestParam UUID usuarioId
    ) {
        UsuarioResponse usuarioResponse = usuarioService.agregarRoleUsuario(role, usuarioId);
        if(usuarioResponse == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usuarioResponse);
    }

    @PatchMapping("/password/{id}")
    public ResponseEntity<Void> changePassword(
            @RequestBody ChangePasswordDto passwordDto,
            @PathVariable(name = "id") UUID usuarioId
            ) {
        usuarioService.changePassword(passwordDto.getPassword(), usuarioId);
        return ResponseEntity.noContent().build();
    }
}
