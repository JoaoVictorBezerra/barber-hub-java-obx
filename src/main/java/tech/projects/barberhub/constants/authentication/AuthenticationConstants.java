package tech.projects.barberhub.constants.authentication;

public class AuthenticationConstants {
    private AuthenticationConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String CREATED = "User was successfully registered!";
    public static final String WRONG_EMAIL_OR_PASSWORD = "Provided email or password is incorrect. Please, provide correct data to access your benefits.";
    public static final String TOKEN_INVALID = "Please, provide a valid token to access your benefits.";

}