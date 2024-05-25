package tech.projects.barberhub.mappers.barbershop_catalog;

import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalog;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalogId;
import tech.projects.barberhub.model.catalog.Catalog;

public final class BarbershopCatalogMapper {
    private BarbershopCatalogId toEmbedId(String barbershopId, String serviceId) {
        return new BarbershopCatalogId(barbershopId, serviceId);
    }

    public BarbershopCatalog toEntity(Barbershop barberShop, Catalog service) {
        BarbershopCatalogId embedId = toEmbedId(barberShop.getId(), service.getId());
        return new BarbershopCatalog(embedId, barberShop, service);
    }
}
