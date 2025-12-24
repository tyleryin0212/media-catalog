package com.tyleryin.medialibrary.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Direction client -> server, used by POST /items
 * represents what a client is allowed to send
 *
 */
public class CreateItemRequest {

    @NotNull
    private ItemType type;

    @NotBlank
    private String title;

    @Min(0)
    private int year;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

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
