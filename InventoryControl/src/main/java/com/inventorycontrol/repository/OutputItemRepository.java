package com.inventorycontrol.repository;

import com.inventorycontrol.model.ExitModel;
import com.inventorycontrol.model.OutputItemModel;
import com.inventorycontrol.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OutputItemRepository extends JpaRepository<OutputItemModel, UUID> {

    List<OutputItemModel> findOutputItemModelByProductModel(ProductModel productModel);
}
