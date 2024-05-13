package tech.projects.barberhub.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.constants.barbershop.BarbershopConstants;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.dto.barbershop.AddServiceOnBarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.service.BarbershopService;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(Routes.BARBERSHOP)
public class BarbershopController {
    private final BarbershopService barberShopService;

    public BarbershopController(BarbershopService barberShopService) {
        this.barberShopService = barberShopService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDTO> createBarbershop(@RequestBody CreateBarbershopDTO body) {
        String barbershopId = barberShopService.createBarberShop(body.name(), body.description(), body.address(), body.contact());
        return ResponseEntity.created(URI.create("/api/barbershop/" + barbershopId)).body(new DefaultResponseDTO(BarbershopConstants.CREATED, Instant.now()));
    }

    @GetMapping
    public ResponseEntity<List<BarbershopDTO>> getAllBarbershops() {
        List<BarbershopDTO> barbershopList = barberShopService.getBarberShops();
        return ResponseEntity.ok().body(barbershopList);
    }

    @PostMapping("/{barbershopId}")
    public ResponseEntity<DefaultResponseDTO> assignServiceToBarbershop(@PathVariable("barbershopId") String barbershopId,  @RequestBody AddServiceOnBarbershopDTO body) {
        barberShopService.assignServiceToBarbershop(barbershopId, body.serviceId());
        return ResponseEntity.created(URI.create("/api/barbershop/" + barbershopId)).body(new DefaultResponseDTO(BarbershopConstants.CREATED, Instant.now()));
    }
}
