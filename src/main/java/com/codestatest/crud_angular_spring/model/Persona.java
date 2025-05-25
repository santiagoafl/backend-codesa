package com.codestatest.crud_angular_spring.model;

import jakarta.persistence.*;


import lombok.Data;
import java.time.LocalDate;

import com.codestatest.crud_angular_spring.validation.FechaPasada;

@MappedSuperclass
@Data
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @FechaPasada
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;
}

