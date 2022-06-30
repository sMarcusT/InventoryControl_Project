package com.inventorycontrol.repository;

import com.inventorycontrol.model.EntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntryRepository extends JpaRepository<EntryModel, UUID> {
}
