package com.inventorycontrol.service;

import com.inventorycontrol.exception.CityNotFoundException;
import com.inventorycontrol.model.CityModel;
import com.inventorycontrol.repository.CityRepository;
import com.inventorycontrol.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;


    public List<CityModel> findAll(){
        return cityRepository.findAll();
    }

    public CityModel findById(UUID uuid){
        return cityRepository.findById(uuid).orElseThrow(() -> new CityNotFoundException("Cidade não encontrada"));
    }

    public CityModel save(CityModel cityModel){
        return cityRepository.save(cityModel);
    }

    public CityModel update(CityModel cityModel, UUID uuid){
        cityRepository.findById(uuid).orElseThrow(() -> new CityNotFoundException("Cidade não encontrada"));
        cityModel.setCodCity(uuid);
        cityRepository.save(cityModel);
        return cityModel;
    }

    public UUID delete(UUID uuid){
        var cityModel = cityRepository.findById(uuid).orElseThrow(() -> new CityNotFoundException("Cidade não encontrada"));
        cityRepository.delete(cityModel);
        return uuid;
    }
}
