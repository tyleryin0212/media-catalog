package com.tyleryin.medialibrary.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    private CreatorEntity creator;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    protected ItemEntity() {}

    public ItemEntity(UUID id, CreatorEntity creator, String title, int year) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.year = year;
    }

    public UUID getId() { return id; }
    public CreatorEntity getCreator() { return creator; }
    public String getTitle() { return title; }
    public int getYear() { return year; }

    public void setTitle(String title) { this.title = title; }
    public void setYear(int year) { this.year = year; }
    public void setCreator(CreatorEntity creator) { this.creator = creator; }

}
