package tech.projects.barberhub.constants.barbershop;

public class BarbershopConstants {

    private BarbershopConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String CREATED = "Barbershop successfully registered!";
    public static final String NOT_FOUND = "We don't found any result with provided ID";
    public static final String SERVICE_ASSIGNED = "Service was successfully assigned!";
    public static final String ALREADY_EXISTS = "A barbershop with provided name was already registered.";

}
