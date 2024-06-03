package tech.projects.barberhub.model.barbershop_catalog;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BarbershopCatalogId implements Serializable {
    @Column(name = "barbershop_id")
    private String barbershopId;

    @Column(name = "service_id")
    private String serviceId;

    public BarbershopCatalogId(String barbershopId, String serviceId) {
        this.barbershopId = barbershopId;
        this.serviceId = serviceId;
    }

    public BarbershopCatalogId() {
    }

    public String getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(String barbershopId) {
        this.barbershopId = barbershopId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
