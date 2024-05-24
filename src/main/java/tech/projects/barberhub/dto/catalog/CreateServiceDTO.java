package tech.projects.barberhub.dto.catalog;

public record CreateServiceDTO(
        String name,
        String description,
        String imageUrl,
        double price
) {
}
