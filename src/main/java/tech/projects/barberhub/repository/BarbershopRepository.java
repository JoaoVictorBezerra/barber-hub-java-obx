package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.barbershop.Barbershop;

import java.util.Optional;

public interface BarbershopRepository extends JpaRepository<Barbershop, String> {
    Optional<Barbershop> findBySlug(String slug);
}
