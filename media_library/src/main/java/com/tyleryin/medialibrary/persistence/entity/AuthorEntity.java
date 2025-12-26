package com.tyleryin.medialibrary.persistence.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "authors")
@DiscriminatorValue("AUTHOR")
public class AuthorEntity extends CreatorEntity {

    protected AuthorEntity() {}
    public AuthorEntity(UUID id, String displayName) { super(id, displayName); }

}

