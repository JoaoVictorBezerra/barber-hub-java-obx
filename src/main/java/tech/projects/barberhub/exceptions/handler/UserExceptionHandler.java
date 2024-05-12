package tech.projects.barberhub.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.exceptions.users.UserAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.users.UserNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DefaultResponseDTO> handleUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<DefaultResponseDTO> handleUserAlreadyRegistered(UserAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }
}