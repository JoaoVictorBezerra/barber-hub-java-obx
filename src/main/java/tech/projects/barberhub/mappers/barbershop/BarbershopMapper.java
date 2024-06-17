package tech.projects.barberhub.mappers.barbershop;

import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDetailDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.dto.barbershop_catalog.BarbershopCatalogDTO;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.schedule.Schedule;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public final class BarbershopMapper {
    public BarbershopDetailDTO toDetailDto(Barbershop barbershop) {
        return new BarbershopDetailDTO(
              barbershop.getId(),
              barbershop.getName(),
              barbershop.getSlug(),
              barbershop.getImageUrl(),
              barbershop.getAddress(),
              barbershop.getDescription(),
              barbershop.getContact(),
              toCatalogList(barbershop.getServices()),
              toScheduleList(barbershop.getSchedules()),
              barbershop.getCreatedAt(),
              barbershop.getUpdatedAt()
        );
    }

    public BarbershopDTO toDto(Barbershop barbershop) {
        return new BarbershopDTO(
              barbershop.getId(),
              barbershop.getName(),
              barbershop.getImageUrl(),
              barbershop.getAddress()
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
              null,
              Instant.now(),
              null
        );
    }

    public Barbershop toEntityUpdate(CreateBarbershopDTO dto, Barbershop entity) {
        Barbershop barbershop = new Barbershop();
        updateFields(dto, entity, barbershop);
        return barbershop;
    }

    private static void updateFields(CreateBarbershopDTO dto, Barbershop entity, Barbershop barbershop) {
        barbershop.setId(entity.getId());
        barbershop.setName(dto.name());
        barbershop.setSlug(StringHelpers.createSlug(dto.name()));
        barbershop.setImageUrl(dto.imageUrl());
        barbershop.setAddress(dto.address());
        barbershop.setDescription(dto.description());
        barbershop.setContact(dto.contact());
        barbershop.setServices(entity.getServices());
        barbershop.setSchedules(entity.getSchedules());
        barbershop.setCreatedAt(entity.getCreatedAt());
        barbershop.setUpdatedAt(Instant.now());
    }

    private List<BarbershopCatalogDTO> toCatalogList(List<BarbershopCatalog> barbershopCatalog) {
        return barbershopCatalog.stream().map(this::toCatalogDTO).toList();
    }

    private BarbershopCatalogDTO toCatalogDTO(BarbershopCatalog barbershopCatalog) {
        return new BarbershopCatalogDTO(
              barbershopCatalog.getServices().getId(),
              barbershopCatalog.getServices().getName(),
              barbershopCatalog.getServices().getDescription(),
              barbershopCatalog.getServices().getImageUrl(),
              barbershopCatalog.getServices().getPrice()
        );
    }

    private List<String> toScheduleList(List<Schedule> schedules) {
        return schedules.stream().map(schedule -> schedule.getDate()
                    .toString())
              .toList();
    }
}