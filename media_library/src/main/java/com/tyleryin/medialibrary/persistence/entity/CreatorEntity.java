package com.tyleryin.medialibrary.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "creators")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "creator_type", discriminatorType = DiscriminatorType.STRING)

public abstract class CreatorEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    //optional shared column(recommended)
    @Column(name = "display_name", nullable = false)
    private String displayName;

    protected CreatorEntity(){}

    protected CreatorEntity(UUID id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public UUID getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

}
