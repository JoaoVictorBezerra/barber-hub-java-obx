package tech.projects.barberhub.mappers.catalog;

import tech.projects.barberhub.dto.catalog.CreateServiceDTO;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.model.entity.catalog.Catalog;

import java.time.Instant;
import java.util.UUID;

public final class CatalogMapper {
    public Catalog toEntity(CreateServiceDTO dto) {
        return new Catalog(
                UUID.randomUUID().toString(),
                dto.name(),
                StringHelpers.createSlug(dto.name()),
                dto.description(),
                dto.price(),
                Instant.now(),
                null
        );
    }
}
