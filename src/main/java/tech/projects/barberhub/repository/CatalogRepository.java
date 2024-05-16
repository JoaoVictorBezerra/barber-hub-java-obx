package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entity.catalog.Catalog;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
    Optional<Catalog> findServicesByName(String name);

    Optional<Catalog> findCatalogBySlug(String slug);
}
