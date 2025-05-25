package com.codestatest.crud_angular_spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

import com.codestatest.crud_angular_spring.validation.FechaPasada;

@Entity
@Table(name = "profesor")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Profesor extends Persona {

    @Column(nullable = false)
    private String especialidad;

    @FechaPasada
    @Column(nullable = false)
    private LocalDate fechaContratacion;
}