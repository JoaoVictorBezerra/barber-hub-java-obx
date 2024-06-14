package tech.projects.barberhub.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.constants.barbershop.BarbershopConstants;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.dto.barbershop.AddServiceOnBarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDetailDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.security.annotations.HasAdminRole;
import tech.projects.barberhub.service.interfac.BarbershopService;

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

    @HasAdminRole
    @PostMapping
    public ResponseEntity<DefaultResponseDTO> createBarbershop(@Valid @RequestBody CreateBarbershopDTO body) {
        String barbershopId = barberShopService.createBarberShop(body);
        return ResponseEntity.created(URI.create("/api/barbershop/" + barbershopId)).body(new DefaultResponseDTO(BarbershopConstants.CREATED, Instant.now()));
    }

    @GetMapping
    public ResponseEntity<List<BarbershopDTO>> getAllBarbershops() {
        List<BarbershopDTO> barbershopList = barberShopService.getBarberShops();
        return ResponseEntity.ok().body(barbershopList);
    }

    @HasAdminRole
    @PostMapping("/{barbershopId}")
    public ResponseEntity<DefaultResponseDTO> assignServiceToBarbershop(@PathVariable("barbershopId") String barbershopId, @Valid @RequestBody AddServiceOnBarbershopDTO body) {
        barberShopService.assignServiceToBarbershop(barbershopId, body.serviceId());
        return ResponseEntity.created(URI.create("/api/barbershop/" + barbershopId)).body(new DefaultResponseDTO(BarbershopConstants.SERVICE_ASSIGNED, Instant.now()));
    }

    @HasAdminRole
    @PutMapping("/{barbershopId}")
    public ResponseEntity<BarbershopDTO> updateBarbershop(@PathVariable("barbershopId") String barbershopId, @Valid @RequestBody CreateBarbershopDTO body) {
        BarbershopDTO response = barberShopService.updateBarbershop(barbershopId, body);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{barbershopId}")
    public ResponseEntity<BarbershopDetailDTO> getBarbershopDetail(@PathVariable("barbershopId") String id) {
        BarbershopDetailDTO detailDTO = barberShopService.getBarbershopDetail(id);
        return ResponseEntity.ok(detailDTO);
    }
}
