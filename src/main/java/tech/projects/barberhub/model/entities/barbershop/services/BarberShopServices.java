package tech.projects.barberhub.model.entities.barbershop.services;

import jakarta.persistence.*;
import tech.projects.barberhub.model.entities.barbershop.BarberShop;

@Entity(name = "barber_shop_services")
@Table(name = "barber_shop_services")
public class BarberShopServices {
    @EmbeddedId
    private BarberShopServicesId id;

    @ManyToOne
    @MapsId("barberShopId")
    @JoinColumn(name = "barbershop_id")
    private BarberShop barberShop;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Services services;

    public BarberShopServices(BarberShopServicesId id, BarberShop barberShop, Services services) {
        this.id = id;
        this.barberShop = barberShop;
        this.services = services;
    }

    public BarberShopServices() {
    }

    public BarberShopServicesId getId() {
        return id;
    }

    public void setId(BarberShopServicesId id) {
        this.id = id;
    }

    public BarberShop getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
