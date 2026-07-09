package com.codigo.spring_g17.service;

import com.codigo.spring_g17.dto.input.ArticuloCreateDto;
import com.codigo.spring_g17.dto.ouput.ArticuloCreateResponse;
import com.codigo.spring_g17.entity.ArticuloEntity;
import com.codigo.spring_g17.entity.UsuarioEntity;
import com.codigo.spring_g17.repository.ArticuloRepository;
import com.codigo.spring_g17.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;
    private final UsuarioRepository usuarioRepository;

    public ArticuloService(ArticuloRepository articuloRepository,
                           UsuarioRepository usuarioRepository) {
        this.articuloRepository = articuloRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ArticuloCreateResponse createArticulo(ArticuloCreateDto articuloCreateDto) {
        Optional<UsuarioEntity> optionalUsuario = usuarioRepository
                .findById(articuloCreateDto.getIdUsuario());
        if (optionalUsuario.isEmpty()) {
            return null;
        }
        UsuarioEntity usuarioEntity = optionalUsuario.get();

        String fechaActual = new Date(System.currentTimeMillis()).toString();

        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setTitulo(articuloCreateDto.getTitulo());
        articuloEntity.setContenido(articuloCreateDto.getContenido());
        articuloEntity.setFechaCreacion(fechaActual);
        articuloEntity.setFechaActualizacion(fechaActual);
        articuloEntity.setUsuarioEntity(usuarioEntity);

        articuloRepository.save(articuloEntity);

        return new ArticuloCreateResponse(
                articuloEntity.getIdArticulo(),
                articuloEntity.getTitulo(),
                articuloEntity.getContenido(),
                articuloEntity.getFechaCreacion(),
                articuloEntity.getFechaActualizacion(),
                usuarioEntity.getNombre()
        );
    }
}
