package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.model.entities.barbershop.BarberShop;
import tech.projects.barberhub.model.entities.barbershop.services.BarberShopServices;
import tech.projects.barberhub.model.entities.barbershop.services.BarberShopServicesId;
import tech.projects.barberhub.model.entities.barbershop.services.Services;
import tech.projects.barberhub.repositories.BarberShopServicesRepository;

@Service
public class BarberShopServicesService {
    private final BarberShopServicesRepository barberShopServicesRepository;

    public BarberShopServicesService(BarberShopServicesRepository barberShopServicesRepository) {
        this.barberShopServicesRepository = barberShopServicesRepository;
    }

    private BarberShopServicesId createEmbedId(String barbershopId, String serviceId) {
        return new BarberShopServicesId(barbershopId, serviceId);
    }

    public void addServiceToBarbershop(BarberShop barberShop, Services service) {
        BarberShopServicesId embedId = createEmbedId(barberShop.getId(), service.getId());
        BarberShopServices barberShopServices = new BarberShopServices(embedId, barberShop, service);
        barberShopServicesRepository.save(barberShopServices);
    }
}
