package tech.projects.barberhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.constants.services.ServicesConstants;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.dto.services.CreateServiceDTO;
import tech.projects.barberhub.service.ServicesService;

import java.net.URI;
import java.time.Instant;

@RestController
@RequestMapping(Routes.SERVICES)
public class ServicesController {
    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDTO> createService(@RequestBody CreateServiceDTO body) {
        String serviceId = servicesService.createService(body.name(), body.description(), body.price());
        return ResponseEntity.created(URI.create("/api/services/" + serviceId)).body(new DefaultResponseDTO(ServicesConstants.CREATED, Instant.now()));
    }
}
