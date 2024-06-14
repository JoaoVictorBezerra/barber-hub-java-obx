package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.schedule.ScheduleConstants;
import tech.projects.barberhub.dto.schedule.CreateScheduleDTO;
import tech.projects.barberhub.dto.schedule.ScheduleResponseDTO;
import tech.projects.barberhub.exceptions.schedule.ScheduledOnBarbershopClosedException;
import tech.projects.barberhub.exceptions.schedule.ScheduledOnIncorrectTimeException;
import tech.projects.barberhub.exceptions.schedule.ScheduledOnUnavailableTimeException;
import tech.projects.barberhub.mappers.schedule.ScheduleMapper;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.model.schedule.Schedule;
import tech.projects.barberhub.model.user.User;
import tech.projects.barberhub.repository.ScheduleRepository;
import tech.projects.barberhub.service.interfac.BarbershopService;
import tech.projects.barberhub.service.interfac.CatalogService;
import tech.projects.barberhub.service.interfac.ScheduleService;
import tech.projects.barberhub.service.interfac.UserService;

import java.time.DayOfWeek;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final BarbershopService barbershopService;
    private final CatalogService catalogService;
    private final UserService userService;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper = new ScheduleMapper();

    public ScheduleServiceImpl(BarbershopService barbershopService, CatalogService catalogService, UserService userService, ScheduleRepository scheduleRepository) {
        this.barbershopService = barbershopService;
        this.catalogService = catalogService;
        this.userService = userService;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDTO createSchedule(CreateScheduleDTO dto) {
        Schedule schedule = buildScheduleEntity(dto);
        int scheduledMinute = dto.date().atZone(ZoneOffset.UTC).getMinute();
        String scheduledDay = dto.date().atZone(ZoneOffset.UTC).getDayOfWeek().name();

        if (scheduledMinute != 30 && scheduledMinute != 0) {
            throw new ScheduledOnIncorrectTimeException(ScheduleConstants.INCORRECT_TIME);
        }

        if(scheduledDay.equals(DayOfWeek.SUNDAY.name())) {
            throw new ScheduledOnBarbershopClosedException(ScheduleConstants.BARBERSHOP_CLOSED);
        }

        boolean alreadyScheduled = schedule.getBarbershopId()
              .getSchedules()
              .stream()
              .anyMatch(p0 -> p0.getDate().equals(dto.date()));

        if (alreadyScheduled) {
            throw new ScheduledOnUnavailableTimeException(ScheduleConstants.ALREADY_SCHEDULED);
        }

        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public List<ScheduleResponseDTO> getScheduleByUserId(String userId) {
        User user = userService.getUserEntityById(userId);
        List<Schedule> scheduleList = scheduleRepository.findScheduleByUserId(user);
        return scheduleList.stream().map(scheduleMapper::toDto).toList();
    }

    @Override
    public List<ScheduleResponseDTO> getScheduleByBarbershopId(String barbershopId) {
        Barbershop user = barbershopService.getBarbershopEntityById(barbershopId);
        List<Schedule> scheduleList = scheduleRepository.findScheduleByBarbershopId(user);
        return scheduleList.stream().map(scheduleMapper::toDto).toList();
    }

    private Schedule buildScheduleEntity(CreateScheduleDTO dto) {
        Barbershop barbershop = barbershopService.getBarbershopEntityById(dto.barbershopId());
        Catalog service = catalogService.findServiceById(dto.serviceId());
        User user = userService.getUserEntityById(dto.userId());
        return scheduleMapper.toEntity(dto, barbershop, service, user);
    }
}
