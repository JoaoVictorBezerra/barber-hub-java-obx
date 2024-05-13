package tech.projects.barberhub.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.exceptions.catalog.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.catalog.ServiceNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class CatalogExceptionHandler {
    @ExceptionHandler(ServiceAlreadyRegisteredException.class)
    public ResponseEntity<DefaultResponseDTO> handleServiceAlreadyExists(ServiceAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<DefaultResponseDTO> handleServiceNotFound(ServiceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }
}