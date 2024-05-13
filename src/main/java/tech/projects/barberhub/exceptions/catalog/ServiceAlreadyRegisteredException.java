package tech.projects.barberhub.exceptions.catalog;

public class ServiceAlreadyRegisteredException extends RuntimeException {
    public ServiceAlreadyRegisteredException(String message) {
        super(message);
    }
}
