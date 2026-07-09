package com.codigo.spring_g17.repository;

import com.codigo.spring_g17.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticuloRepository extends JpaRepository<ArticuloEntity, UUID> {
}
