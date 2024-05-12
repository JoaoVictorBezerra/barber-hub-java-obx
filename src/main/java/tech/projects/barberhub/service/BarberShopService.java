package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.model.entities.barbershop.BarberShop;
import tech.projects.barberhub.model.entities.barbershop.services.BarberShopServices;
import tech.projects.barberhub.repositories.BarberShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarberShopService {
    private final BarberShopRepository barberShopRepository;

    public BarberShopService(BarberShopRepository barberShopRepository) {
        this.barberShopRepository = barberShopRepository;
    }

    public List<BarberShop> getBarberShops() {
        return barberShopRepository.findAll();
    }

    public String createBarberShop(String name, String description, String address, String contact) {
        BarberShop barberShop = new BarberShop();
        barberShop.setName(name);
        barberShop.setDescription(description);
        barberShop.setAddress(address);
        barberShop.setContact(contact);
        List<BarberShopServices> services = new ArrayList<>();
        barberShop.setServices(services);
        barberShopRepository.save(barberShop);
        return barberShop.getId();
    }
}
