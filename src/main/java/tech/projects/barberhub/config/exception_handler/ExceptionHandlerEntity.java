package tech.projects.barberhub.config.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.constants.responses.exceptions.security.RoleNotAllowedException;
import tech.projects.barberhub.constants.responses.exceptions.users.UserNotFoundException;
import tech.projects.barberhub.dto.DefaultErrorDTO;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerEntity {
    @ExceptionHandler(RoleNotAllowedException.class)
    public ResponseEntity<DefaultErrorDTO> handleRoleNotAllowed(RoleNotAllowedException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DefaultErrorDTO> handleUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }
}