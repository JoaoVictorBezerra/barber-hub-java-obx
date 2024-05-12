package tech.projects.barberhub.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.exceptions.security.RoleNotAllowedException;

import java.time.Instant;

@ControllerAdvice
public class RoleExceptionHandler {
    @ExceptionHandler(RoleNotAllowedException.class)
    public ResponseEntity<DefaultResponseDTO> handleRoleNotAllowed(RoleNotAllowedException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }
}