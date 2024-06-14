package tech.projects.barberhub.dto.schedule;

import tech.projects.barberhub.constants.enums.ScheduleStatusEnum;

import java.time.Instant;

public record ScheduleResponseDTO(
      String id,
      ScheduleStatusEnum status,
      ScheduleBarbershopDTO barbershop,
      ScheduleServiceDTO service,
      Instant date
) {
}
