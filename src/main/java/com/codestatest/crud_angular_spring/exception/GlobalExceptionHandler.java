package com.codestatest.crud_angular_spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> manejarNoEncontrado(NoSuchElementException ex) {
        log.error("No se encontró el recurso: {}", ex.getMessage());
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Recurso no encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejarValidaciones(MethodArgumentNotValidException ex) {
        log.warn("Error de validación: {}", ex.getMessage());
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarErrorGeneral(Exception ex) {
        log.error("Error interno inesperado", ex);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Error interno del servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> manejarArgumentoInvalido(IllegalArgumentException ex) {
        log.warn("Error de argumento inválido: {}", ex.getMessage());
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }	    
}