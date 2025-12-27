package com.tyleryin.medialibrary.persistence.mapper;

import com.tyleryin.medialibrary.in_memory_domain.Author;
import com.tyleryin.medialibrary.in_memory_domain.Band;
import com.tyleryin.medialibrary.in_memory_domain.Creator;
import com.tyleryin.medialibrary.in_memory_domain.RecordingArtist;
import com.tyleryin.medialibrary.persistence.entity.AuthorEntity;
import com.tyleryin.medialibrary.persistence.entity.BandEntity;
import com.tyleryin.medialibrary.persistence.entity.CreatorEntity;
import com.tyleryin.medialibrary.persistence.entity.RecordingArtistEntity;

public class CreatorMapper {
    private CreatorMapper() {}

    public static CreatorEntity toEntity(Creator creator) {
        if(creator instanceof Author) {
            return new AuthorEntity(creator.getId(), creator.getName());
        }
        if(creator instanceof RecordingArtist) {
            return new RecordingArtistEntity(creator.getId(), creator.getName());
        }
        if(creator instanceof Band) {
            return new BandEntity(creator.getId(), creator.getName());
        }
        throw new IllegalArgumentException("Invalid creator type: " + creator.getClass());
    }
}
