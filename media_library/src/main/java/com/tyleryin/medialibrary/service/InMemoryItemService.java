package com.tyleryin.medialibrary.service;


import com.tyleryin.medialibrary.in_memory_domain.Creator;
import com.tyleryin.medialibrary.in_memory_domain.Item;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * decides how to create items, translates DTO to domain
 */
@Service
public class InMemoryItemService implements ItemService {

    private final Map<UUID, Item> items = new ConcurrentHashMap<>();

    @Override
    public Item createItem(Item item) {
        // If you want "no overwrite" semantics:
        // if (items.putIfAbsent(item.getId(), item) != null) throw ...
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> getById(UUID id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public boolean deleteById(UUID id) {
        return items.remove(id) != null;
    }

    @Override
    public Optional<Item> updateById(UUID id, ItemPatch patch) {
        return Optional.ofNullable(items.computeIfPresent(id, (k, oldItem) -> {
            String newTitle = (patch.title() != null) ? patch.title() : oldItem.getTitle();
            int newYear = (patch.year() != null) ? patch.year() : oldItem.getYear();
            Creator newCreator = (patch.creator() != null) ? patch.creator() : oldItem.getCreator();

            // Create a NEW Item (immutability preserved)
            return new Item(oldItem.getId(), newCreator, newTitle, newYear);
        }));
    }
}
