package tech.projects.barberhub.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.constants.catalog.CatalogConstants;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.security.annotations.HasAdminRole;
import tech.projects.barberhub.service.interfac.CatalogService;
import tech.projects.barberhub.dto.catalog.CreateServiceDTO;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(Routes.CATALOG)
public class CatalogController {
    private final CatalogService catalogService;
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @HasAdminRole
    @PostMapping("/service")
    public ResponseEntity<DefaultResponseDTO> createService(@Valid @RequestBody CreateServiceDTO body) {
        String serviceId = catalogService.createService(body);
        return ResponseEntity.created(URI.create("/api/services/" + serviceId)).body(new DefaultResponseDTO(CatalogConstants.CREATED, Instant.now()));
    }
    @GetMapping
    public ResponseEntity<List<Catalog>> getCatalog() {
        List<Catalog> catalog = catalogService.getAllServices();
        return ResponseEntity.ok().body(catalog);
    }
    @HasAdminRole
    @DeleteMapping("/service/{serviceId}")
    public ResponseEntity<DefaultResponseDTO> deleteService(@PathVariable("serviceId") String serviceId) {
        catalogService.deleteService(serviceId);
        return ResponseEntity.ok().body(new DefaultResponseDTO(CatalogConstants.DELETED, Instant.now()));
    }

    @HasAdminRole
    @PutMapping("/service/{serviceId}")
    public ResponseEntity<Catalog> updateService(@PathVariable("serviceId") String serviceId, @Valid @RequestBody CreateServiceDTO dto) {
        Catalog updatedService = catalogService.updateCatalog(serviceId, dto);
        return ResponseEntity.ok().body(updatedService);
    }
}
