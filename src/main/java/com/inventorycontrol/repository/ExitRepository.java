package com.inventorycontrol.repository;

import com.inventorycontrol.model.ExitModel;
import com.inventorycontrol.model.ShippingCompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExitRepository extends JpaRepository<ExitModel, UUID> {

    List<ExitModel> findExitModelByShippingCompanyModel(ShippingCompanyModel shippingCompanyModel);
}
