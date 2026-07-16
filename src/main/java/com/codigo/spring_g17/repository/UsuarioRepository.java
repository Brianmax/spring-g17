package com.codigo.spring_g17.repository;

import com.codigo.spring_g17.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    boolean existsByUsername(String username);
    boolean existsByDni(String dni);
}
