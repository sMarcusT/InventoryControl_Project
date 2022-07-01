package com.inventorycontrol.repository;

import com.inventorycontrol.model.ExitItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExitItemRepository extends JpaRepository<ExitItemModel, UUID> {
}
