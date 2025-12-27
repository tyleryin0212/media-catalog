package com.tyleryin.medialibrary.persistence.mapper;

import com.tyleryin.medialibrary.in_memory_domain.Creator;
import com.tyleryin.medialibrary.in_memory_domain.Item;
import com.tyleryin.medialibrary.persistence.entity.CreatorEntity;
import com.tyleryin.medialibrary.persistence.entity.ItemEntity;

public class ItemMapper {
    private ItemMapper(){}

    public static ItemEntity toItemEntity(Item item, CreatorEntity creatorEntity) {
        return new ItemEntity((item.getId()), creatorEntity, item.getTitle(), item.getYear());
    }
}
