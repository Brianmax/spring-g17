package com.codigo.spring_g17.controller;

import com.codigo.spring_g17.dto.input.ArticuloCreateDto;
import com.codigo.spring_g17.dto.input.ArticuloUpdateDto;
import com.codigo.spring_g17.dto.ouput.ArticuloCreateResponse;
import com.codigo.spring_g17.service.ArticuloService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @PostMapping("/save")
    public ResponseEntity<ArticuloCreateResponse> crearArticulo(
            @Valid @RequestBody ArticuloCreateDto articuloCreateDto) {
        ArticuloCreateResponse articuloResponse = articuloService
                .createArticulo(articuloCreateDto);
        if (articuloResponse == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(articuloResponse);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ArticuloCreateResponse> updateArticulo(
            @RequestBody ArticuloUpdateDto articuloUpdateDto,
            @PathVariable(name = "id") UUID idArticulo
            ) {
        ArticuloCreateResponse acr = articuloService.updateArticulo(idArticulo, articuloUpdateDto);
        if(acr == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().body(acr);
    }
}
