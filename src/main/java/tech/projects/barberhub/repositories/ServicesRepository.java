package tech.projects.barberhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entities.barbershop.services.Services;

import java.util.Optional;

public interface ServicesRepository extends JpaRepository<Services, String> {
    Optional<Services> findServicesByName(String name);
}
