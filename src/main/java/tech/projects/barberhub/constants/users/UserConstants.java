package tech.projects.barberhub.constants.users;

public class UserConstants {
    private UserConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String NOT_FOUND = "User not found with e-mail: ";
    public static final String ALREADY_REGISTERED = "User already registered with e-mail: ";
}