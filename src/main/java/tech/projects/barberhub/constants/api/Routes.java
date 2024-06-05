package tech.projects.barberhub.constants.api;

public class Routes {
    private Routes() {
        throw new IllegalStateException("Utility class");
    }
    public static final String AUTHENTICATION = "/api/auth";
    public static final String CATALOG = "/api/catalog";
    public static final String BARBERSHOP = "/api/barbershop";
    public static final String SENDMAIL = "/api/sendmail";
}
