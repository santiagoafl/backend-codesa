//  Arquitectura de Capas 
package com.codestatest.crud_angular_spring.controller;
import com.codestatest.crud_angular_spring.model.Estudiante;
import com.codestatest.crud_angular_spring.service.EstudianteService;
import jakarta.validation.Valid;

//manejo de logs
import lombok.extern.slf4j.Slf4j;

// Para uso de REST
import org.springframework.web.bind.annotation.*;

// Manejo de paginacion
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

// ModelMapper y DTO
import com.codestatest.crud_angular_spring.dto.EstudianteDTO;
import org.modelmapper.ModelMapper;

@Slf4j //logs
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

	private final EstudianteService service;
	private final ModelMapper modelMapper;

	public EstudianteController(EstudianteService service, ModelMapper modelMapper) {
	    this.service = service;
	    this.modelMapper = modelMapper;
	}
	@GetMapping
	public Page<EstudianteDTO> listarConPaginacion(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size,
	        @RequestParam(defaultValue = "apellido") String sortBy
	) {
	    log.info("Listando estudiantes - página {}, tamaño {}, ordenado por {}", page, size, sortBy);
	    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	    Page<Estudiante> pagina = service.listarPaginado(pageable);
	    return pagina.map(est -> modelMapper.map(est, EstudianteDTO.class));
	}


	@GetMapping("/{id}")
	public EstudianteDTO buscar(@PathVariable Long id) {
	    log.info("Buscando estudiante con ID {}", id);
	    Estudiante est = service.buscarPorId(id).orElseThrow();
	    return modelMapper.map(est, EstudianteDTO.class);
	}


	@GetMapping("/buscar/nombre")
	public Page<EstudianteDTO> buscarPorNombre(
	        @RequestParam String nombre,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size
	) {
	    log.info("Buscando estudiantes por nombre '{}', página {}", nombre, page);
	    Pageable pageable = PageRequest.of(page, size);
	    return service.buscarPorNombre(nombre, pageable)
	            .map(est -> modelMapper.map(est, EstudianteDTO.class));
	}


	@GetMapping("/buscar/apellido")
	public Page<EstudianteDTO> buscarPorApellido(
	        @RequestParam String apellido,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size
	) {
	    log.info("Buscando estudiantes por apellido '{}'", apellido);
	    Pageable pageable = PageRequest.of(page, size);
	    return service.buscarPorApellido(apellido, pageable)
	            .map(est -> modelMapper.map(est, EstudianteDTO.class));
	}


	@GetMapping("/buscar/grado")
	public Page<EstudianteDTO> buscarPorGrado(
	        @RequestParam String grado,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size
	) {
	    log.info("Buscando estudiantes por grado '{}'", grado);
	    Pageable pageable = PageRequest.of(page, size);
	    return service.buscarPorGrado(grado, pageable)
	            .map(est -> modelMapper.map(est, EstudianteDTO.class));
	}


	@GetMapping("/buscar/matricula")
	public Page<EstudianteDTO> buscarPorNumeroMatricula(
	        @RequestParam String numeroMatricula,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size
	) {
	    log.info("Buscando estudiante por matrícula '{}'", numeroMatricula);
	    Pageable pageable = PageRequest.of(page, size);
	    return service.buscarPorNumeroMatricula(numeroMatricula, pageable)
	            .map(est -> modelMapper.map(est, EstudianteDTO.class));
	}

	@PostMapping
	public EstudianteDTO crear(@RequestBody @Valid EstudianteDTO estudianteDTO) {
	    log.info("Creando nuevo estudiante: {}", estudianteDTO);
	    Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
	    Estudiante guardado = service.crear(estudiante);
	    return modelMapper.map(guardado, EstudianteDTO.class);
	}

	@PutMapping("/{id}")
	public EstudianteDTO actualizar(@PathVariable Long id, @RequestBody @Valid EstudianteDTO estudianteDTO) {
	    log.info("Actualizando estudiante con ID {}: {}", id, estudianteDTO);
	    Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
	    Estudiante actualizado = service.actualizar(id, estudiante);
	    return modelMapper.map(actualizado, EstudianteDTO.class);
	}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        log.warn("Eliminando estudiante con ID {}", id);
        service.eliminar(id);
    }
}


