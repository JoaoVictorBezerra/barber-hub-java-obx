package tech.projects.barberhub.dto.barbershop;

import tech.projects.barberhub.dto.barbershop_catalog.BarbershopCatalogDTO;

import java.time.Instant;
import java.util.List;

public record BarbershopDTO(
        String id,
        String name,
        String slug,
        String imageUrl,
        String address,
        String description,
        String contact,
        List<BarbershopCatalogDTO> services,
        Instant createdAt,
        Instant updatedAt
) {
}
