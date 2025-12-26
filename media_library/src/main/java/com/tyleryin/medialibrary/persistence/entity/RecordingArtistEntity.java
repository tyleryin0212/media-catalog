package com.tyleryin.medialibrary.persistence.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "recording_artists")
@DiscriminatorValue("RECORDING_ARTIST")
public class RecordingArtistEntity extends CreatorEntity{
    protected RecordingArtistEntity() {}
    public RecordingArtistEntity(UUID id, String displayName) { super(id, displayName); }
}
