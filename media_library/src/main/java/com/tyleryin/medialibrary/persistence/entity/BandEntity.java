package com.tyleryin.medialibrary.persistence.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "bands")
@DiscriminatorValue("BAND")
public class BandEntity extends CreatorEntity{
    protected BandEntity() {}
    public BandEntity(UUID id, String displayName) { super(id, displayName); }
}
