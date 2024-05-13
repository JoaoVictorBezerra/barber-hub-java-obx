package tech.projects.barberhub.model.entity.barbershop_catalog;

import jakarta.persistence.*;
import tech.projects.barberhub.model.entity.barbershop.Barbershop;
import tech.projects.barberhub.model.entity.catalog.Catalog;

@Entity(name = "barbershop_catalog")
@Table(name = "barbershop_catalog")
public class BarbershopCatalog {
    @EmbeddedId
    private BarbershopCatalogId id;

    @ManyToOne
    @MapsId("barbershopId")
    @JoinColumn(name = "barbershop_id")
    private Barbershop barberShop;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Catalog catalog;

    public BarbershopCatalog(BarbershopCatalogId id, Barbershop barberShop, Catalog catalog) {
        this.id = id;
        this.barberShop = barberShop;
        this.catalog = catalog;
    }

    public BarbershopCatalog() {
    }

    public BarbershopCatalogId getId() {
        return id;
    }

    public void setId(BarbershopCatalogId id) {
        this.id = id;
    }

    public Barbershop getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(Barbershop barberShop) {
        this.barberShop = barberShop;
    }

    public Catalog getServices() {
        return catalog;
    }

    public void setServices(Catalog catalog) {
        this.catalog = catalog;
    }
}
