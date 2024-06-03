package tech.projects.barberhub.model.barbershop;

import jakarta.persistence.*;
import tech.projects.barberhub.model.barbershop_catalog.BarbershopCatalog;

import java.time.Instant;
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
    private String slug;

    @Column(nullable = false, name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String contact;

    @OneToMany(mappedBy = "barberShop")
    private List<BarbershopCatalog> services;

    @Column(nullable = false, name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Barbershop(String id, String name, String slug, String imageUrl, String address, String description, String contact, List<BarbershopCatalog> services, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
        this.address = address;
        this.description = description;
        this.contact = contact;
        this.services = services;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
