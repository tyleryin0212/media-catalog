package com.tyleryin.medialibrary.service;

import com.tyleryin.medialibrary.in_memory_domain.Creator;
import com.tyleryin.medialibrary.in_memory_domain.Item;
import com.tyleryin.medialibrary.persistence.entity.CreatorEntity;
import com.tyleryin.medialibrary.persistence.entity.ItemEntity;
import com.tyleryin.medialibrary.persistence.mapper.CreatorMapper;
import com.tyleryin.medialibrary.persistence.repo.CreatorRepository;
import com.tyleryin.medialibrary.persistence.repo.ItemRepository;
import com.tyleryin.medialibrary.service.ItemPatch;
import com.tyleryin.medialibrary.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class JpaItemService implements ItemService {

    private final ItemRepository itemRepo;
    private final CreatorRepository creatorRepo;

    public JpaItemService(ItemRepository itemRepo, CreatorRepository creatorRepo) {
        this.itemRepo = itemRepo;
        this.creatorRepo = creatorRepo;
    }

    @Override
    @Transactional
    public Item createItem(Item item) {
        CreatorEntity creatorEntity = upsertCreator(item.getCreator());
        ItemEntity saved = itemRepo.save(new ItemEntity(item.getId(), creatorEntity, item.getTitle(), item.getYear()));
        return toDomain(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> getById(UUID id) {
        return itemRepo.findById(id).map(this::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> getAll() {
        return itemRepo.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    @Transactional
    public boolean deleteById(UUID id) {
        if (!itemRepo.existsById(id)) return false;
        itemRepo.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public Optional<Item> updateById(UUID id, ItemPatch patch) {
        Optional<ItemEntity> opt = itemRepo.findById(id);
        if (opt.isEmpty()) return Optional.empty();

        ItemEntity e = opt.get();

        if (patch.title() != null) e.setTitle(patch.title());
        if (patch.year() != null) e.setYear(patch.year());

        if (patch.creator() != null) {
            CreatorEntity newCreator = upsertCreator(patch.creator());
            e.setCreator(newCreator);
        }

        ItemEntity saved = itemRepo.save(e);
        return Optional.of(toDomain(saved));
    }

    private CreatorEntity upsertCreator(Creator creator) {
        return creatorRepo.findById(creator.getId())
                .orElseGet(() -> creatorRepo.save(CreatorMapper.toEntity(creator)));
    }

    /**
     * Entity -> Domain mapping.
     *
     * IMPORTANT: your domain Creator subtypes (Author/RecordingArtist/Band) may need structured fields (Name).
     * But DB currently stores only displayName + id. So for reads, we return a simple Creator implementation.
     */
    private Item toDomain(ItemEntity e) {
        CreatorEntity c = e.getCreator();
        Creator creator = new PersistedCreator(c.getId(), c.getDisplayName()); // see below
        return new Item(e.getId(), creator, e.getTitle(), e.getYear());
    }

    /** Minimal read-model creator to avoid losing info / forcing first-last parsing. */
    private record PersistedCreator(UUID id, String name) implements Creator {
        @Override public UUID getId() { return id; }
        @Override public String getName() { return name; }
    }
}