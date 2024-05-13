package tech.projects.barberhub.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.exceptions.security.IncorrectPasswordOrEmailException;
import tech.projects.barberhub.exceptions.security.InvalidTokenException;

import java.time.Instant;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    @ExceptionHandler(IncorrectPasswordOrEmailException.class)
    public ResponseEntity<DefaultResponseDTO> handleIncorrectPasswordOrEmail(IncorrectPasswordOrEmailException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<DefaultResponseDTO> handleInvalidToken(InvalidTokenException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DefaultResponseDTO(exception.getMessage(), Instant.now()));
    }
}