package tech.projects.barberhub.mappers.barbershop;

import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.dto.barbershop_catalog.BarbershopCatalogDTO;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalog;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public final class BarbershopMapper {
    public BarbershopDTO toDto(Barbershop barbershop) {
        return new BarbershopDTO(
                barbershop.getId(),
                barbershop.getName(),
                barbershop.getSlug(),
                barbershop.getImageUrl(),
                barbershop.getAddress(),
                barbershop.getDescription(),
                barbershop.getContact(),
                toCatalogList(barbershop.getServices()),
                barbershop.getCreatedAt(),
                barbershop.getUpdatedAt()
        );
    }

    public Barbershop toEntity(CreateBarbershopDTO dto) {
        return new Barbershop(
                UUID.randomUUID().toString(),
                dto.name(),
                StringHelpers.createSlug(dto.name()),
                dto.imageUrl(),
                dto.address(),
                dto.description(),
                dto.contact(),
                null,
                Instant.now(),
                null
        );
    }

    public Barbershop toEntityUpdate(BarbershopDTO dto, Barbershop entity) {
        Barbershop barbershop = new Barbershop();
        updateFields(dto, entity, barbershop);
        return barbershop;
    }

    private static void updateFields(BarbershopDTO dto, Barbershop entity, Barbershop barbershop) {
        barbershop.setId(entity.getId());
        barbershop.setName(dto.name());
        barbershop.setSlug(StringHelpers.createSlug(dto.name()));
        barbershop.setImageUrl(dto.imageUrl());
        barbershop.setAddress(dto.address());
        barbershop.setDescription(dto.description());
        barbershop.setContact(dto.contact());
        barbershop.setCreatedAt(entity.getCreatedAt());
        barbershop.setUpdatedAt(Instant.now());
    }

    private List<BarbershopCatalogDTO> toCatalogList(List<BarbershopCatalog> barbershopCatalog) {
        return barbershopCatalog.stream().map(this::toCatalogDTO).toList();
    }

    public BarbershopCatalogDTO toCatalogDTO(BarbershopCatalog barbershopCatalog) {
        return new BarbershopCatalogDTO(
                barbershopCatalog.getServices().getName(),
                barbershopCatalog.getServices().getDescription(),
                barbershopCatalog.getServices().getPrice()
        );
    }
}