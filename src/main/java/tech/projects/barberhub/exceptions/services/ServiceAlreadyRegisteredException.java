package tech.projects.barberhub.exceptions.services;

public class ServiceAlreadyRegisteredException extends RuntimeException {
    public ServiceAlreadyRegisteredException(String message) {
        super(message);
    }
}
