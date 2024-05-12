package tech.projects.barberhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.projects.barberhub.model.entities.barbershop.services.BarberShopServices;

@Repository
public interface BarberShopServicesRepository extends JpaRepository<BarberShopServices, String> {
}
