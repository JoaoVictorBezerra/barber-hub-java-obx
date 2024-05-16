package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.mappers.barbershop_catalog.BarbershopCatalogMapper;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalogId;
import tech.projects.barberhub.model.entity.catalog.Catalog;
import tech.projects.barberhub.repository.BarbershopCatalogRepository;

@Service
public class BarbershopCatalogService {
    private final BarbershopCatalogRepository barberShopCatalogRepository;

    BarbershopCatalogMapper barbershopCatalogMapper = new BarbershopCatalogMapper();

    public BarbershopCatalogService(BarbershopCatalogRepository barberShopCatalogRepository) {
        this.barberShopCatalogRepository = barberShopCatalogRepository;
    }

    public void addServiceToBarbershop(Barbershop barberShop, Catalog service) {
        BarbershopCatalog barberShopCatalog = barbershopCatalogMapper.toEntity(barberShop, service);
        barberShopCatalogRepository.save(barberShopCatalog);
    }
}
