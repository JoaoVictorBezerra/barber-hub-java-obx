package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.catalog.CatalogConstants;

import tech.projects.barberhub.dto.catalog.CreateServiceDTO;
import tech.projects.barberhub.exceptions.catalog.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.catalog.ServiceNotFoundException;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.mappers.catalog.CatalogMapper;
import tech.projects.barberhub.model.entity.catalog.Catalog;
import tech.projects.barberhub.repository.CatalogRepository;

import java.util.List;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    CatalogMapper catalogMapper = new CatalogMapper();
  
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> getAllServices() {
        return catalogRepository.findAll();
    }
    public Catalog findServiceById(String id) {
        return catalogRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(CatalogConstants.NOT_FOUND));
    }

    public void deleteService(String id) {
        boolean exists = existsById(id);
        if(!exists) {
            throw new ServiceNotFoundException(CatalogConstants.NOT_FOUND);
        }
        catalogRepository.deleteById(id);
    }

    public String createService(CreateServiceDTO createServiceDTO) {
        boolean alreadyExist = serviceAlreadyExistsByName(createServiceDTO.name());
        if(alreadyExist) {
            throw new ServiceAlreadyRegisteredException(CatalogConstants.ALREADY_EXISTS);
        }
        Catalog service = catalogMapper.toEntity(createServiceDTO);
        catalogRepository.save(service);
        return service.getId();
    }

    private boolean serviceAlreadyExistsByName(String name){
        return catalogRepository.findServicesByName(name).isPresent();
    }

    private boolean serviceAlreadyExistsBySlug(String name){
        return catalogRepository.findCatalogBySlug(StringHelpers.createSlug(name)).isPresent();
    }

    private boolean existsById(String id){
        return catalogRepository.findById(id).isPresent();
    }
}
