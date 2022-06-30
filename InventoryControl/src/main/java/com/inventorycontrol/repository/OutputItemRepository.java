package com.inventorycontrol.repository;

import com.inventorycontrol.model.OutputItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutputItemRepository extends JpaRepository<OutputItemModel, UUID> {
}
