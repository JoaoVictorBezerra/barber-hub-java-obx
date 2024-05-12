package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.catalog.CatalogConstants;
import tech.projects.barberhub.exceptions.catalog.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.catalog.ServiceNotFoundException;
import tech.projects.barberhub.model.entity.catalog.Catalog;
import tech.projects.barberhub.repository.CatalogRepository;

import java.util.List;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> getAllServices() {
        return catalogRepository.findAll();
    }
    public Catalog findServiceById(String id) {
        return catalogRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(CatalogConstants.NOT_FOUND));
    }

    public String createService(String name, String description, double price) {
        boolean alreadyExist = serviceAlreadyExistsByName(name);
        if(alreadyExist) {
            throw new ServiceAlreadyRegisteredException(CatalogConstants.ALREADY_EXISTS);
        }
        Catalog service = new Catalog();
        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);
        catalogRepository.save(service);
        return service.getId();
    }

    public boolean serviceAlreadyExistsByName(String name){
        List<Catalog> services = getAllServices();
        return services.stream().anyMatch(service -> service.getName().equalsIgnoreCase(name));
    }
}
