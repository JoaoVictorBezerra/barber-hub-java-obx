package tech.projects.barberhub.model.entities.barbershop;

import jakarta.persistence.*;
import tech.projects.barberhub.model.entities.barbershop.services.BarberShopServices;

import java.util.List;

@Entity(name = "barbershop")
@Table(name = "barbershop")
public class BarberShop {
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
    private List<BarberShopServices> services;

    public BarberShop(String id, String name, String address, String description, String contact, List<BarberShopServices> services) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.contact = contact;
        this.services = services;
    }

    public BarberShop() {
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

    public List<BarberShopServices> getServices() {
        return services;
    }

    public void setServices(List<BarberShopServices> services) {
        this.services = services;
    }
}
