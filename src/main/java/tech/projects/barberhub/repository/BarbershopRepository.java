package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;

public interface BarbershopRepository extends JpaRepository<Barbershop, String> {
}
