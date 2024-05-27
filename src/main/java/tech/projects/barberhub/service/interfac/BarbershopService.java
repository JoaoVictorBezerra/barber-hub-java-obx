package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;

import java.util.List;

public interface BarbershopService {
    List<BarbershopDTO> getBarberShops();
    BarbershopDTO getBarbershopById(String id);
    String createBarberShop(CreateBarbershopDTO dto);
    void assignServiceToBarbershop(String barbershopId, String serviceId);
    BarbershopDTO updateBarbershop(String barbershopId, CreateBarbershopDTO dto);
}
