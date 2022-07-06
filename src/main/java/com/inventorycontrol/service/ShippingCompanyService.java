package com.inventorycontrol.service;

import com.inventorycontrol.exception.ShippingCompanyNotFoundException;
import com.inventorycontrol.model.ShippingCompanyModel;
import com.inventorycontrol.repository.ShippingCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ShippingCompanyService {

    private final ShippingCompanyRepository shippingCompanyRepository;

    public List<ShippingCompanyModel> findAll() {
        return shippingCompanyRepository.findAll();
    }

    public ShippingCompanyModel findById(UUID uuid) {
        return shippingCompanyRepository.findById(uuid).orElseThrow(() -> new ShippingCompanyNotFoundException("Transportadora não encontrada."));
    }

    public ShippingCompanyModel save(ShippingCompanyModel shippingCompanyModel) {
        return shippingCompanyRepository.save(shippingCompanyModel);
    }

    public ShippingCompanyModel update(ShippingCompanyModel shippingCompanyModel, UUID uuid) {
        shippingCompanyRepository.findById(uuid).orElseThrow(() -> new ShippingCompanyNotFoundException("Transportadora não encontrada."));
        shippingCompanyModel.setCodShippingCompany(uuid);
        shippingCompanyRepository.save(shippingCompanyModel);
        return shippingCompanyModel;
    }

    public UUID delete(UUID uuid) {
        var shippingCompanyModel = shippingCompanyRepository.findById(uuid).orElseThrow(() -> new ShippingCompanyNotFoundException("Transportadora não encontrada."));
        shippingCompanyRepository.delete(shippingCompanyModel);
        return uuid;
    }
}
