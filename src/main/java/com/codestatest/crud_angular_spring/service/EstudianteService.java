package com.codestatest.crud_angular_spring.service;

import com.codestatest.crud_angular_spring.model.Estudiante;
import com.codestatest.crud_angular_spring.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }
    // Filtro de nombre
    public Page<Estudiante> buscarPorNombre(String nombre, Pageable pageable) {
        return repository.findByNombreContainingIgnoreCase(nombre, pageable);
    }
    // Filtro de apellido
    public Page<Estudiante> buscarPorApellido(String apellido, Pageable pageable) {
        return repository.findByApellidoContainingIgnoreCase(apellido, pageable);
    }
    // Filtro de grado
    public Page<Estudiante> buscarPorGrado(String grado, Pageable pageable) {
        return repository.findByGrado(grado, pageable);
    }
    // Filtro Numero de matricula
    public Page<Estudiante> buscarPorNumeroMatricula(String numeroMatricula, Pageable pageable) {
        return repository.findByNumeroMatriculaContainingIgnoreCase(numeroMatricula, pageable);
    }

    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Estudiante crear(Estudiante estudiante) {
        if (repository.existsByEmail(estudiante.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }
        if (repository.existsByNumeroMatricula(estudiante.getNumeroMatricula())) {
            throw new IllegalArgumentException("El número de matrícula ya existe.");
        }
        return repository.save(estudiante);
    }
    
    public Page<Estudiante> listarPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Estudiante actualizar(Long id, Estudiante estudiante) {
        Estudiante existente = repository.findById(id).orElseThrow();
        existente.setNumeroMatricula(estudiante.getNumeroMatricula());
        existente.setGrado(estudiante.getGrado());
        existente.setNombre(estudiante.getNombre());
        existente.setApellido(estudiante.getApellido());
        existente.setFechaNacimiento(estudiante.getFechaNacimiento());
        existente.setEmail(estudiante.getEmail());
        existente.setTelefono(estudiante.getTelefono());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
