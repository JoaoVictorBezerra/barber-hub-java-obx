package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.mappers.barbershop_catalog.BarbershopCatalogMapper;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.repository.BarbershopCatalogRepository;
import tech.projects.barberhub.service.interfac.BarbershopCatalogService;

@Service
public class BarbershopCatalogServiceImpl implements BarbershopCatalogService {
    private final BarbershopCatalogRepository barberShopCatalogRepository;

    BarbershopCatalogMapper barbershopCatalogMapper = new BarbershopCatalogMapper();
  
    public BarbershopCatalogServiceImpl(BarbershopCatalogRepository barberShopCatalogRepository) {
        this.barberShopCatalogRepository = barberShopCatalogRepository;
    }

    public void addServiceToBarbershop(Barbershop barberShop, Catalog service) {
        BarbershopCatalog barberShopCatalog = barbershopCatalogMapper.toEntity(barberShop, service);
        barberShopCatalogRepository.save(barberShopCatalog);
    }
}
