package com.codestatest.crud_angular_spring.repository;

import com.codestatest.crud_angular_spring.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	boolean existsByEmail(String email);
    Page<Profesor> findByEspecialidadContainingIgnoreCase(String especialidad, Pageable pageable);
}
