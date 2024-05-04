package tech.projects.barberhub.constants.responses.exceptions.security;

public class RoleNotAllowedException extends RuntimeException {
    public RoleNotAllowedException(String message) {
        super(message);
    }
}
