package tech.projects.barberhub.mappers.schedule;

import tech.projects.barberhub.constants.enums.ScheduleStatusEnum;
import tech.projects.barberhub.dto.schedule.CreateScheduleDTO;
import tech.projects.barberhub.dto.schedule.ScheduleBarbershopDTO;
import tech.projects.barberhub.dto.schedule.ScheduleResponseDTO;
import tech.projects.barberhub.dto.schedule.ScheduleServiceDTO;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.model.schedule.Schedule;
import tech.projects.barberhub.model.user.User;

import java.util.UUID;

public final class ScheduleMapper {
    public Schedule toEntity(CreateScheduleDTO dto, Barbershop barbershop, Catalog service, User user) {
        return new Schedule(
              UUID.randomUUID().toString(),
              ScheduleStatusEnum.CONFIRMED,
              barbershop,
              user,
              service,
              dto.date()
        );
    }

    public ScheduleResponseDTO toDto(Schedule entity) {
        return new ScheduleResponseDTO(
              entity.getId(),
              entity.getStatus(),
              toBarbershopDto(entity.getBarbershopId()),
              toServiceDto(entity.getCatalogId()),
              entity.getDate()
        );
    }

    private ScheduleBarbershopDTO toBarbershopDto(Barbershop barbershop) {
        return new ScheduleBarbershopDTO(
              barbershop.getId(),
              barbershop.getName(),
              barbershop.getAddress(),
              barbershop.getImageUrl(),
              barbershop.getContact()
        );
    }

    private ScheduleServiceDTO toServiceDto(Catalog service) {
        return new ScheduleServiceDTO(
              service.getId(),
              service.getName(),
              service.getPrice()
        );
    }
}
