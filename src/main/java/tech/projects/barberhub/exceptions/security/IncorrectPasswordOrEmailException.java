package tech.projects.barberhub.exceptions.security;

public class IncorrectPasswordOrEmailException extends RuntimeException {
    public IncorrectPasswordOrEmailException(String message) {
        super(message);
    }
}
