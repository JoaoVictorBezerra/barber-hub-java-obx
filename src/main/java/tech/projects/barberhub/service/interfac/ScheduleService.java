package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.schedule.CreateScheduleDTO;
import tech.projects.barberhub.dto.schedule.ScheduleResponseDTO;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDTO createSchedule(CreateScheduleDTO dto);

    List<ScheduleResponseDTO> getScheduleByUserEmail(String userId);

    List<ScheduleResponseDTO> getScheduleByBarbershopId(String barbershopId);
}
