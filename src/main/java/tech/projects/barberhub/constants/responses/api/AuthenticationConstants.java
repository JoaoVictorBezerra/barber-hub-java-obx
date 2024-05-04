package tech.projects.barberhub.constants.responses.api;

public class AuthenticationConstants {

    private AuthenticationConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CREATED = "User registered successful!";

    public static final String WRONG_EMAIL_OR_PASSWORD = "Wrong email or password. Verify your data!";
}