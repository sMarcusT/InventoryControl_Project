package com.inventorycontrol.service;

import com.inventorycontrol.exception.ProviderNotFoundException;
import com.inventorycontrol.model.ProviderModel;
import com.inventorycontrol.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public List<ProviderModel> findAll(){
        return providerRepository.findAll();
    }

    public ProviderModel findById(UUID uuid){
        return providerRepository.findById(uuid).orElseThrow(() -> new ProviderNotFoundException("Fornecedor não encontrado."));
    }

    public ProviderModel save(ProviderModel providerModel){
        return  providerRepository.save(providerModel);
    }

    public ProviderModel update(ProviderModel providerModel, UUID uuid){
        providerRepository.findById(uuid).orElseThrow(() -> new ProviderNotFoundException("Fornecedor não encontrado."));
        providerModel.setCodProvider(uuid);
        providerRepository.save(providerModel);
        return providerModel;
    }

    public UUID delete(UUID uuid){
        var forneceforModel = providerRepository.findById(uuid).orElseThrow(() -> new ProviderNotFoundException("Fornecedor não encontrado."));
        providerRepository.delete(forneceforModel);
        return uuid;
    }
}
