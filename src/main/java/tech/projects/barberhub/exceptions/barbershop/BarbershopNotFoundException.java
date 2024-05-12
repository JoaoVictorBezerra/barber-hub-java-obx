package tech.projects.barberhub.exceptions.barbershop;

public class BarbershopNotFoundException extends RuntimeException {
    public BarbershopNotFoundException(String message) {
        super(message);
    }
}
