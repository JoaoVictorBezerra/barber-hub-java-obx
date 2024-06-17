package tech.projects.barberhub.dto.barbershop_catalog;

public record BarbershopCatalogDTO(
      String serviceId,
        String name,
        String description,
        String imageUrl,
        double price
) {
}
