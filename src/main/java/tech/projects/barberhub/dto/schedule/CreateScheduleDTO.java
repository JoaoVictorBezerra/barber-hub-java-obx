package tech.projects.barberhub.dto.schedule;

import java.time.Instant;

public record CreateScheduleDTO(
      String barbershopId,
      String userId,
      String serviceId,
      Instant date
) {
}
