package com.fabish.Ishimwe.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "allocation_logs")
public class AllocationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Timestamp allocatedAt = new Timestamp(System.currentTimeMillis());

    private String action; // allocated

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getAllocatedAt() {
        return allocatedAt;
    }

    public void setAllocatedAt(Timestamp allocatedAt) {
        this.allocatedAt = allocatedAt;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
