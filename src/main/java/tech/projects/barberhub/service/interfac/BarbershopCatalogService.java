package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.catalog.Catalog;

public interface BarbershopCatalogService {
    void addServiceToBarbershop(Barbershop barberShop, Catalog service);
}
