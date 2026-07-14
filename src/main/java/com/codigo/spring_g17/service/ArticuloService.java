package com.codigo.spring_g17.service;

import com.codigo.spring_g17.dto.input.ArticuloCreateDto;
import com.codigo.spring_g17.dto.input.ArticuloUpdateDto;
import com.codigo.spring_g17.dto.ouput.ArticuloCreateResponse;
import com.codigo.spring_g17.entity.ArticuloEntity;
import com.codigo.spring_g17.entity.UsuarioEntity;
import com.codigo.spring_g17.repository.ArticuloRepository;
import com.codigo.spring_g17.repository.UsuarioRepository;
import com.codigo.spring_g17.service.utils.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.sound.midi.MidiUnavailableException;
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

        ArticuloEntity articuloEntity = Mapper.fromArticuloCreateDto(articuloCreateDto);
        articuloEntity.setFechaCreacion(fechaActual);
        articuloEntity.setUsuarioEntity(usuarioEntity);

        articuloRepository.save(articuloEntity);

        return Mapper.fromArticuloEntity(articuloEntity);
    }

    public ArticuloCreateResponse updateArticulo(UUID id, ArticuloUpdateDto articuloUpdateDto) {
        Optional<ArticuloEntity> articuloEntityOptional = articuloRepository.findById(id);
        if(articuloEntityOptional.isEmpty()) {
            return null;
        }

        ArticuloEntity articuloEntity = articuloEntityOptional.get();
        String nuevoTitulo = articuloUpdateDto.getTitulo();
        String nuevoContenido = articuloUpdateDto.getContenido();
        if(nuevoContenido != null && nuevoTitulo != null) {
            articuloEntity.setTitulo(nuevoTitulo);
            articuloEntity.setContenido(nuevoContenido);
        } else if(nuevoContenido != null) {
            articuloEntity.setContenido(nuevoContenido);
        } else if(nuevoTitulo != null) {
            articuloEntity.setTitulo(nuevoTitulo);
        } else {
            return null;
        }

        articuloEntity.setFechaActualizacion(new Date(System.currentTimeMillis()).toString());
        articuloRepository.save(articuloEntity);
        return Mapper.fromArticuloEntity(articuloEntity);
    }

    public void deleteArticulo(UUID idArticulo, boolean isDraft) {
        Optional<ArticuloEntity> articuloEntityOptional = articuloRepository.findById(idArticulo);
        if(articuloEntityOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }
        if(isDraft) {
            ArticuloEntity articuloEntity = articuloEntityOptional.get();
            articuloEntity.setEstado(false);
            articuloRepository.save(articuloEntity);
        } else {
            articuloRepository.deleteById(idArticulo);
        }

    }
}
