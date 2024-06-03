package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.barbershop.Barbershop;

public interface BarbershopRepository extends JpaRepository<Barbershop, String> {
}
