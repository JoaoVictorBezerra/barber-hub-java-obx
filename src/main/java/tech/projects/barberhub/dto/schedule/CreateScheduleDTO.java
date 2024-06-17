package tech.projects.barberhub.dto.schedule;

import java.time.Instant;

public record CreateScheduleDTO(
      String barbershopId,
      String email,
      String serviceId,
      Instant date
) {
}
