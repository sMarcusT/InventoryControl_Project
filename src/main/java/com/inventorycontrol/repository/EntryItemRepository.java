package com.inventorycontrol.repository;

import com.inventorycontrol.model.EntryItemModel;
import com.inventorycontrol.model.OutputItemModel;
import com.inventorycontrol.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntryItemRepository extends JpaRepository<EntryItemModel, UUID> {

    List<EntryItemModel> findEntryItemModelByProductModel(ProductModel productModel);
}
