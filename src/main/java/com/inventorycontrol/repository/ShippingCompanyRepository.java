package com.inventorycontrol.repository;

import com.inventorycontrol.model.ShippingCompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompanyModel, UUID> {
}
