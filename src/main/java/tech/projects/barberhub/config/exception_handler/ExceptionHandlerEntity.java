package tech.projects.barberhub.config.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.projects.barberhub.exceptions.security.IncorrectPasswordOrEmailException;
import tech.projects.barberhub.exceptions.security.InvalidTokenException;
import tech.projects.barberhub.exceptions.security.RoleNotAllowedException;
import tech.projects.barberhub.exceptions.services.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.users.UserAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.users.UserNotFoundException;
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

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<DefaultErrorDTO> handleUserAlreadyRegistered(UserAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(IncorrectPasswordOrEmailException.class)
    public ResponseEntity<DefaultErrorDTO> handleIncorrectPasswordOrEmail(IncorrectPasswordOrEmailException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<DefaultErrorDTO> handleInvalidToken(InvalidTokenException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }

    @ExceptionHandler(ServiceAlreadyRegisteredException.class)
    public ResponseEntity<DefaultErrorDTO> handleServiceAlreadyExists(ServiceAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DefaultErrorDTO(exception.getMessage(), Instant.now()));
    }
}