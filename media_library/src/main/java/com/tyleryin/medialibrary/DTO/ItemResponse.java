package com.tyleryin.medialibrary.DTO;

import com.tyleryin.medialibrary.in_memory_domain.Item;

import java.util.UUID;

/**
 * direction: server -> client
 * used by POST /items, GET /items
 * includes id and exposes data in a controlled way, decouples API from domain internals
 */
public class ItemResponse {
    private UUID id;
    private ItemType type;   // BOOK / MUSIC (keep String for now)
    private String title;
    private int year;

    private String firstName;
    private String lastName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
