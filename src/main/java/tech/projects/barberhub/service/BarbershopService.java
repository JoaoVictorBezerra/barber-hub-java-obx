package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.barbershop.BarbershopConstants;
import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop_catalog.BarbershopCatalogDTO;
import tech.projects.barberhub.exceptions.barbershop.BarbershopNotFoundException;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.entity.catalog.Catalog;
import tech.projects.barberhub.repository.BarbershopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarbershopService {
    private final BarbershopRepository barbershopRepository;
    private final BarbershopCatalogService barberShopCatalogService;
    private final CatalogService catalogService;

    public BarbershopService(BarbershopRepository barbershopRepository, BarbershopCatalogService barberShopCatalogService, CatalogService catalogService) {
        this.barbershopRepository = barbershopRepository;
        this.barberShopCatalogService = barberShopCatalogService;
        this.catalogService = catalogService;
    }

    public List<BarbershopDTO> getBarberShops() {
        List<Barbershop> barbershopList = barbershopRepository.findAll();
        return barbershopList.stream().map(barbershop ->
                new BarbershopDTO(
                        barbershop.getId(),
                        barbershop.getName(),
                        barbershop.getDescription(),
                        barbershop.getAddress(),
                        barbershop.getContact(),
                        barbershop.getServices().stream().map(service ->
                                new BarbershopCatalogDTO(
                                        service.getServices().getName(),
                                        service.getServices().getDescription(),
                                        service.getServices().getPrice()
                                )
                        ).toList()
                )
        ).toList();
    }

    public BarbershopDTO findBarbershopById(String id) {
        Barbershop barbershop = barbershopRepository.findById(id).orElseThrow(() -> new BarbershopNotFoundException(BarbershopConstants.NOT_FOUND));
        List<BarbershopCatalogDTO> services = barbershop.getServices().stream().map(service -> new BarbershopCatalogDTO(service.getServices().getName(), service.getServices().getDescription(), service.getServices().getPrice())).toList();
        return new BarbershopDTO(barbershop.getId(), barbershop.getName(), barbershop.getDescription(), barbershop.getAddress(), barbershop.getContact(), services);
    }

    public String createBarberShop(String name, String description, String address, String contact) {
        Barbershop barberShop = new Barbershop();
        barberShop.setName(name);
        barberShop.setDescription(description);
        barberShop.setAddress(address);
        barberShop.setContact(contact);
        List<BarbershopCatalog> services = new ArrayList<>();
        barberShop.setServices(services);
        barbershopRepository.save(barberShop);
        return barberShop.getId();
    }

    public void assignServiceToBarbershop(String barbershopId, String serviceId) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId).orElseThrow(() -> new BarbershopNotFoundException(BarbershopConstants.NOT_FOUND));
        Catalog catalog = catalogService.findServiceById(serviceId);
        barberShopCatalogService.addServiceToBarbershop(barbershop, catalog);
    }

    private boolean verifyBarbershopExistence(String barbershopId) {
        return barbershopRepository.findById(barbershopId).isPresent();
    }
}
