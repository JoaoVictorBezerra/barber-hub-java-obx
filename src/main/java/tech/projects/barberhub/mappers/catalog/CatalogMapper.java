package tech.projects.barberhub.mappers.catalog;

import tech.projects.barberhub.dto.catalog.CreateServiceDTO;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.model.catalog.Catalog;

import java.time.Instant;
import java.util.UUID;

public final class CatalogMapper {
    public Catalog toEntity(CreateServiceDTO dto) {
        return new Catalog(
                UUID.randomUUID().toString(),
                dto.name(),
                StringHelpers.createSlug(dto.name()),
                dto.imageUrl(),
                dto.description(),
                dto.price(),
                Instant.now(),
                null
        );
    }

    public Catalog toUpdateEntity(CreateServiceDTO dto, Catalog entity) {
        Catalog catalog = new Catalog();
        updateFields(dto, entity, catalog);
        return catalog;
    }

    private static void updateFields(CreateServiceDTO dto, Catalog entity, Catalog catalog) {
        catalog.setId(entity.getId());
        catalog.setName(dto.name());
        catalog.setDescription(dto.description());
        catalog.setImageUrl(dto.imageUrl());
        catalog.setSlug(StringHelpers.createSlug(dto.name()));
        catalog.setPrice(dto.price());
        catalog.setCreatedAt(entity.getCreatedAt());
        catalog.setUpdatedAt(Instant.now());
    }
}
