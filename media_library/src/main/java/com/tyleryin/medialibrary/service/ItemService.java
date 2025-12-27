package com.tyleryin.medialibrary.service;

import com.tyleryin.medialibrary.DTO.CreateItemRequest;
import com.tyleryin.medialibrary.DTO.ItemResponse;
import com.tyleryin.medialibrary.DTO.UpdateItemRequest;
import com.tyleryin.medialibrary.in_memory_domain.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemService {

    Item createItem(Item item);

    Optional<Item> getById(UUID id);

    List<Item> getAll();

    boolean deleteById(UUID id);

    Optional<Item> updateById(UUID id, ItemPatch patch);
}