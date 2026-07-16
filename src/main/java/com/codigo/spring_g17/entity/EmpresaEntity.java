package com.codigo.spring_g17.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "empresa", schema = "users")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    private UUID idEmpresa;
    private Integer numeroDocumento;
}
