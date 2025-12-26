package com.tyleryin.medialibrary.persistence.repo;

import com.tyleryin.medialibrary.persistence.entity.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorRepository extends JpaRepository<CreatorEntity, UUID> {}
