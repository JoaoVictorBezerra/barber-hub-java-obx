package tech.projects.barberhub.model.schedule;

import jakarta.persistence.*;
import tech.projects.barberhub.constants.enums.ScheduleStatusEnum;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.catalog.Catalog;
import tech.projects.barberhub.model.user.User;

import java.time.Instant;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "status")
    private ScheduleStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershopId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Catalog catalogId;

    @Column(name = "date")
    private Instant date;

    public Schedule() {
    }

    public Schedule(String id, ScheduleStatusEnum status, Barbershop barbershopId, User userId, Catalog catalogId, Instant date) {
        this.id = id;
        this.status = status;
        this.barbershopId = barbershopId;
        this.userId = userId;
        this.catalogId = catalogId;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ScheduleStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ScheduleStatusEnum status) {
        this.status = status;
    }

    public Barbershop getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(Barbershop barbershopId) {
        this.barbershopId = barbershopId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Catalog getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Catalog catalogId) {
        this.catalogId = catalogId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
