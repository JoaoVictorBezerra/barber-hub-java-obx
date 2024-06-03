package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalogId;

@Repository
public interface BarbershopCatalogRepository extends JpaRepository<BarbershopCatalog, BarbershopCatalogId> {
}
