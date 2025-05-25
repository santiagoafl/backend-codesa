package com.codestatest.crud_angular_spring.repository;


import com.codestatest.crud_angular_spring.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Validaciones de unicidad
    boolean existsByNumeroMatricula(String numeroMatricula);
    boolean existsByEmail(String email);

    // Filtros por campos
    Page<Estudiante> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    Page<Estudiante> findByApellidoContainingIgnoreCase(String apellido, Pageable pageable);
    Page<Estudiante> findByGrado(String grado, Pageable pageable);
    Page<Estudiante> findByNumeroMatriculaContainingIgnoreCase(String numeroMatricula, Pageable pageable);
}
