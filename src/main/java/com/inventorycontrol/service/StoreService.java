package com.inventorycontrol.service;

import com.inventorycontrol.exception.CityNotFoundException;
import com.inventorycontrol.exception.StoreNotFoundException;
import com.inventorycontrol.model.StoreModel;
import com.inventorycontrol.repository.CityRepository;
import com.inventorycontrol.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    private final CityRepository cityRepository;

    public List<StoreModel> findAll() {
        return storeRepository.findAll();
    }

    public StoreModel findById(UUID uuid) {
        return storeRepository.findById(uuid).orElseThrow(() -> new StoreNotFoundException("Loja não encontrada."));
    }

    public StoreModel save(StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public StoreModel update(StoreModel storeModel, UUID uuid) {
        storeRepository.findById(uuid).orElseThrow(() -> new StoreNotFoundException("Loja não encontrada."));
        storeModel.setCodStore(uuid);
        storeRepository.save(storeModel);
        return storeModel;
    }

    public UUID delete(UUID uuid) {
        var storeModel = storeRepository.findById(uuid).orElseThrow(() -> new StoreNotFoundException("Loja não encontrada."));
        storeRepository.delete(storeModel);
        return uuid;
    }

    public List<StoreModel> findStoresByCity(UUID uuid) {
        return storeRepository.findStoreModelByCityModel(cityRepository.findById(uuid)
                .orElseThrow(() -> new CityNotFoundException("Cidade não encontrada.")));
    }
}
