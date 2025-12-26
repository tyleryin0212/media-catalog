package com.tyleryin.medialibrary.persistence.repo;

import com.tyleryin.medialibrary.persistence.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
}
