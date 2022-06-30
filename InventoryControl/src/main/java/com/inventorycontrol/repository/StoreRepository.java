package com.inventorycontrol.repository;

import com.inventorycontrol.model.CityModel;
import com.inventorycontrol.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<StoreModel, UUID> {

    List<StoreModel> findStoreModelByCityModel(CityModel cityModel);
}
