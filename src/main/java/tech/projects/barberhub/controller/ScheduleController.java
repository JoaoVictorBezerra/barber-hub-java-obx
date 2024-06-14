package tech.projects.barberhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.dto.schedule.CreateScheduleDTO;
import tech.projects.barberhub.dto.schedule.ScheduleResponseDTO;
import tech.projects.barberhub.security.annotations.HasAdminRole;
import tech.projects.barberhub.service.interfac.ScheduleService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(Routes.SCHEDULE)
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    ResponseEntity<ScheduleResponseDTO> createSchedule(@RequestBody CreateScheduleDTO body) {
        ScheduleResponseDTO createdSchedule = scheduleService.createSchedule(body);
        return ResponseEntity.created(URI.create("/api/schedule/" + createdSchedule.id())).build();
    }

    @GetMapping("/user/{id}")
    ResponseEntity<List<ScheduleResponseDTO>> getScheduleListByUserId(@PathVariable("id") String id) {
        List<ScheduleResponseDTO> scheduleList = scheduleService.getScheduleByUserId(id);
        return ResponseEntity.ok(scheduleList);
    }

    @HasAdminRole
    @GetMapping("/barbershop/{id}")
    ResponseEntity<List<ScheduleResponseDTO>> getScheduleListByBarbershopId(@PathVariable("id") String id) {
        List<ScheduleResponseDTO> scheduleList = scheduleService.getScheduleByBarbershopId(id);
        return ResponseEntity.ok(scheduleList);
    }
}
