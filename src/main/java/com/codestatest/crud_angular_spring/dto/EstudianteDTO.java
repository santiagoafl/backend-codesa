package com.codestatest.crud_angular_spring.dto;

import lombok.Data;

import com.codestatest.crud_angular_spring.validation.FechaPasada;

import java.time.LocalDate;

@Data
public class EstudianteDTO {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String grado;
    private String telefono;    
    @FechaPasada
    private LocalDate fechaNacimiento;
    private String numeroMatricula;
}