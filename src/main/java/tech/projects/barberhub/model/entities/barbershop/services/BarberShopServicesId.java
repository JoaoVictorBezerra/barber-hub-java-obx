package tech.projects.barberhub.model.entities.barbershop.services;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BarberShopServicesId {
    @Column(name = "barbershop_id")
    private String barberShopId;

    @Column(name = "service_id")
    private String serviceId;

    public BarberShopServicesId(String barberShopId, String serviceId) {
        this.barberShopId = barberShopId;
        this.serviceId = serviceId;
    }

    public BarberShopServicesId() {
    }

    public String getBarberShopId() {
        return barberShopId;
    }

    public void setBarberShopId(String barberShopId) {
        this.barberShopId = barberShopId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
