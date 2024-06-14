package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.barbershop.BarbershopDTO;
import tech.projects.barberhub.dto.barbershop.BarbershopDetailDTO;
import tech.projects.barberhub.dto.barbershop.CreateBarbershopDTO;
import tech.projects.barberhub.model.barbershop.Barbershop;

import java.util.List;

public interface BarbershopService {
    List<BarbershopDTO> getBarberShops();
    BarbershopDTO getBarbershopById(String id);
    Barbershop getBarbershopEntityById(String id);
    String createBarberShop(CreateBarbershopDTO dto);
    void assignServiceToBarbershop(String barbershopId, String serviceId);
    BarbershopDTO updateBarbershop(String barbershopId, CreateBarbershopDTO dto);
    BarbershopDetailDTO getBarbershopDetail(String id);
}
