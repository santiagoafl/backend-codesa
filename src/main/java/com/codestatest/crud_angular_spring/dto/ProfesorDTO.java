package com.codestatest.crud_angular_spring.dto;

import lombok.Data;

import java.time.LocalDate;

import com.codestatest.crud_angular_spring.validation.FechaPasada;

@Data
public class ProfesorDTO {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    @FechaPasada
    private LocalDate fechaNacimiento;  
    @FechaPasada    
    private LocalDate fechaContratacion;
    private String especialidad;
}