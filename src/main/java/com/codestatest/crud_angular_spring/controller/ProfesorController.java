//  Arquitectura de Capas 
package com.codestatest.crud_angular_spring.controller;
import com.codestatest.crud_angular_spring.model.Profesor;
import com.codestatest.crud_angular_spring.service.ProfesorService;
import jakarta.validation.Valid;


//manejo de logs
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


//Para uso de REST
import org.springframework.web.bind.annotation.*;


//ModelMapper y DTO
import com.codestatest.crud_angular_spring.dto.ProfesorDTO;
import org.modelmapper.ModelMapper;

@Slf4j
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;
    private final ModelMapper modelMapper;

    public ProfesorController(ProfesorService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Page<ProfesorDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        log.info("Listando profesores - página {}, tamaño {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return service.listar(pageable).map(prof ->
                modelMapper.map(prof, ProfesorDTO.class));
    }

    @GetMapping("/{id}")
    public ProfesorDTO buscar(@PathVariable Long id) {
        log.info("Buscando profesor con ID {}", id);
        Profesor profesor = service.buscarPorId(id).orElseThrow();
        return modelMapper.map(profesor, ProfesorDTO.class);
    }

    @GetMapping("/buscar/especialidad")
    public Page<ProfesorDTO> buscarPorEspecialidad(
            @RequestParam String especialidad,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        log.info("Buscando profesores por especialidad '{}', página {}", especialidad, page);
        Pageable pageable = PageRequest.of(page, size);
        return service.buscarPorEspecialidad(especialidad, pageable)
                .map(prof -> modelMapper.map(prof, ProfesorDTO.class));
    }

    @PostMapping
    public ProfesorDTO crear(@RequestBody @Valid ProfesorDTO profesorDTO) {
        log.info("Creando profesor: {}", profesorDTO);
        Profesor profesor = modelMapper.map(profesorDTO, Profesor.class);
        Profesor guardado = service.crear(profesor);
        return modelMapper.map(guardado, ProfesorDTO.class);
    }

    @PutMapping("/{id}")
    public ProfesorDTO actualizar(@PathVariable Long id, @RequestBody @Valid ProfesorDTO profesorDTO) {
        log.info("Actualizando profesor con ID {}: {}", id, profesorDTO);
        Profesor profesor = modelMapper.map(profesorDTO, Profesor.class);
        Profesor actualizado = service.actualizar(id, profesor);
        return modelMapper.map(actualizado, ProfesorDTO.class);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        log.warn("Eliminando profesor con ID {}", id);
        service.eliminar(id);
    }
}