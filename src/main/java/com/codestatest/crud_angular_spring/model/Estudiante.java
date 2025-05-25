package com.codestatest.crud_angular_spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "estudiante")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Estudiante extends Persona {

    @Column(name = "numero_matricula", nullable = false, unique = true)
    private String numeroMatricula;

    @Column(nullable = false)
    private String grado;
}