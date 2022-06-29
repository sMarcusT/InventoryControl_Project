package com.inventorycontrol.repository;

import com.inventorycontrol.model.CityModel;
import com.inventorycontrol.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityModel, UUID> {
}
