package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.catalog.CreateServiceDTO;
import tech.projects.barberhub.model.catalog.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getAllServices();
    Catalog findServiceById(String id);
    void deleteService(String id);
    String createService(CreateServiceDTO createServiceDTO);
}
