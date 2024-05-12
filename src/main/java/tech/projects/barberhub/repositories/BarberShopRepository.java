package tech.projects.barberhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entities.barbershop.BarberShop;

public interface BarberShopRepository extends JpaRepository<BarberShop, String> {
}
