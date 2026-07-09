package com.codigo.spring_g17.repository;

import com.codigo.spring_g17.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    @Query(nativeQuery = true, value = "select * from users.role where nombre = :nombre")
    Optional<RoleEntity> findByNombe(String nombre);
}
