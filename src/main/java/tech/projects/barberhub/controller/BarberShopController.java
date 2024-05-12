package tech.projects.barberhub.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.constants.barbershop.BarberShopConstants;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarberShopDTO;
import tech.projects.barberhub.model.entities.barbershop.BarberShop;
import tech.projects.barberhub.service.BarberShopService;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(Routes.BARBERSHOP)
public class BarberShopController {
    private final BarberShopService barberShopService;

    public BarberShopController(BarberShopService barberShopService) {
        this.barberShopService = barberShopService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDTO> createBarbershop(@RequestBody CreateBarberShopDTO body) {
        String barberShopId = barberShopService.createBarberShop(body.name(), body.description(), body.address(), body.contact());
        return ResponseEntity.created(URI.create("/api/barbershop/" + barberShopId)).body(new DefaultResponseDTO(BarberShopConstants.CREATED, Instant.now()));
    }

    @GetMapping
    public ResponseEntity<List<BarberShop>> getAllBarbershops() {
        List<BarberShop> barbershopList = barberShopService.getBarberShops();
        return ResponseEntity.ok().body(barbershopList);
    }
}
