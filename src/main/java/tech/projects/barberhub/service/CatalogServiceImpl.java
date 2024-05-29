package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.catalog.CatalogConstants;

import tech.projects.barberhub.dto.catalog.CreateServiceDTO;
import tech.projects.barberhub.exceptions.catalog.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.catalog.ServiceNotFoundException;
import tech.projects.barberhub.helpers.StringHelpers;
import tech.projects.barberhub.mappers.catalog.CatalogMapper;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.repository.CatalogRepository;
import tech.projects.barberhub.service.interfac.CatalogService;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    CatalogMapper catalogMapper = new CatalogMapper();
  
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> getAllServices() {
        return catalogRepository.findAll();
    }
    @Override
    public Catalog findServiceById(String id) {
        return catalogRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(CatalogConstants.NOT_FOUND));
    }

    @Override
    public void deleteService(String id) {
        boolean exists = existsById(id);
        if(!exists) {
            throw new ServiceNotFoundException(CatalogConstants.NOT_FOUND);
        }
        catalogRepository.deleteById(id);
    }

    @Override
    public String createService(CreateServiceDTO createServiceDTO) {
        boolean alreadyExist = serviceAlreadyExistsByName(createServiceDTO.name());
        if(alreadyExist) {
            throw new ServiceAlreadyRegisteredException(CatalogConstants.ALREADY_EXISTS);
        }
        Catalog service = catalogMapper.toEntity(createServiceDTO);
        catalogRepository.save(service);
        return service.getId();
    }

    @Override
    public Catalog updateCatalog(String serviceId, CreateServiceDTO dto) {
        Catalog entity = findServiceById(serviceId);
        return catalogMapper.toUpdateEntity(dto, entity);
    }

    private boolean serviceAlreadyExistsByName(String name){
        return catalogRepository.findServicesByName(name).isPresent();
    }

    private boolean existsById(String id){
        return catalogRepository.findById(id).isPresent();
    }
}
