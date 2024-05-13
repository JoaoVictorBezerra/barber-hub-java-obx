package tech.projects.barberhub.model.entity.barbershop;

import jakarta.persistence.*;
import tech.projects.barberhub.model.entity.barbershop_catalog.BarbershopCatalog;

import java.util.List;

@Entity(name = "barbershop")
@Table(name = "barbershop")
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String contact;


    @OneToMany(mappedBy = "barberShop")
    private List<BarbershopCatalog> services;

    public Barbershop(String id, String name, String address, String description, String contact, List<BarbershopCatalog> services) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.contact = contact;
        this.services = services;
    }

    public Barbershop() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<BarbershopCatalog> getServices() {
        return services;
    }

    public void setServices(List<BarbershopCatalog> services) {
        this.services = services;
    }
}
