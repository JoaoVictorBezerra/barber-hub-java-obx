package tech.projects.barberhub.model.entity.catalog;

import jakarta.persistence.*;

@Entity(name = "catalog")
@Table(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "service_id")
    private String serviceId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    public Catalog() {
    }

    public Catalog(String serviceId, String name, String description, double price) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return serviceId;
    }

    public void setId(String id) {
        this.serviceId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
