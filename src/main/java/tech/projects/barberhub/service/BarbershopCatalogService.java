package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalogId;
import tech.projects.barberhub.model.entity.catalog.Catalog;
import tech.projects.barberhub.repository.BarbershopCatalogRepository;

@Service
public class BarbershopCatalogService {
    private final BarbershopCatalogRepository barberShopCatalogRepository;

    public BarbershopCatalogService(BarbershopCatalogRepository barberShopCatalogRepository) {
        this.barberShopCatalogRepository = barberShopCatalogRepository;
    }

    private BarbershopCatalogId createEmbedId(String barbershopId, String serviceId) {
        return new BarbershopCatalogId(barbershopId, serviceId);
    }

    public void addServiceToBarbershop(Barbershop barberShop, Catalog service) {
        BarbershopCatalogId embedId = createEmbedId(barberShop.getId(), service.getId());
        BarbershopCatalog barberShopCatalog = new BarbershopCatalog(embedId, barberShop, service);
        barberShopCatalogRepository.save(barberShopCatalog);
    }
}
