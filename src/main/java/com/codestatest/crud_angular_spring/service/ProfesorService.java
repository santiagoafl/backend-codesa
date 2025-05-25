package com.codestatest.crud_angular_spring.service;

import com.codestatest.crud_angular_spring.model.Profesor;
import com.codestatest.crud_angular_spring.repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public Page<Profesor> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Profesor> buscarPorId(Long id) {
        return repository.findById(id);
    }
    	// Create 
    public Profesor crear(Profesor profesor) {
        if (repository.existsByEmail(profesor.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }
        return repository.save(profesor);
    }
   	// Update
    public Profesor actualizar(Long id, Profesor profesor) {
        Profesor actual = repository.findById(id).orElseThrow();
        actual.setNombre(profesor.getNombre());
        actual.setApellido(profesor.getApellido());
        actual.setFechaNacimiento(profesor.getFechaNacimiento());
        actual.setEmail(profesor.getEmail());
        actual.setTelefono(profesor.getTelefono());
        actual.setEspecialidad(profesor.getEspecialidad());
        actual.setFechaContratacion(profesor.getFechaContratacion());
        return repository.save(actual);
    }
    // Delete
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Page<Profesor> buscarPorEspecialidad(String especialidad, Pageable pageable) {
        return repository.findByEspecialidadContainingIgnoreCase(especialidad, pageable);
    }
}
