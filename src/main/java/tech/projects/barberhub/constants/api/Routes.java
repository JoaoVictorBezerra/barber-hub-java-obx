package tech.projects.barberhub.constants.api;

public class Routes {
    private Routes() {
        throw new IllegalStateException("Utility class");
    }

    public static final String AUTHENTICATION = "/api/auth";
    public static final String USERS = "/api/users";
    public static final String SERVICES = "/api/services";

}
