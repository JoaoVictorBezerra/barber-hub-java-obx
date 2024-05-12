package tech.projects.barberhub.constants.catalog;

public class CatalogConstants {
    private CatalogConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String CREATED = "Service was successfully created.";
    public static final String ALREADY_EXISTS = "Service already exists.";
    public static final String DELETED = "Service was successfully deleted.";
    public static final String NOT_FOUND = "Service not found.";
}
