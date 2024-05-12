package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.services.ServicesConstants;
import tech.projects.barberhub.exceptions.services.ServiceAlreadyRegisteredException;
import tech.projects.barberhub.model.entities.barbershop.services.Services;
import tech.projects.barberhub.repositories.ServicesRepository;

import java.util.List;

@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public String createService(String name, String description, double price) {
        boolean alreadyExist = serviceAlreadyExists(name);
        if(alreadyExist) {
            throw new ServiceAlreadyRegisteredException(ServicesConstants.ALREADY_EXISTS);
        }
        Services service = new Services();
        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);
        servicesRepository.save(service);
        return service.getId();
    }

    public boolean serviceAlreadyExists(String name){
        List<Services> services = getAllServices();
        return services.stream().anyMatch(service -> service.getName().equalsIgnoreCase(name));
    }
}
