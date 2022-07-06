package com.inventorycontrol.service;

import com.inventorycontrol.exception.ShippingCompanyNotFoundException;
import com.inventorycontrol.model.EntryModel;
import com.inventorycontrol.repository.EntryRepository;
import com.inventorycontrol.exception.EntryNotFoundException;
import com.inventorycontrol.repository.ShippingCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EntryService {

    private final EntryRepository entryRepository;

    private final ShippingCompanyRepository shippingCompanyRepository;

    public List<EntryModel> findAll() {
        return entryRepository.findAll();
    }

    public EntryModel findById(UUID uuid) {
        return entryRepository.findById(uuid).orElseThrow(() -> new EntryNotFoundException("Entrada não encontrada"));
    }

    public EntryModel save(EntryModel entryModel) {
        return entryRepository.save(entryModel);
    }

    public EntryModel update(EntryModel entryModel, UUID uuid) {
        entryRepository.findById(uuid).orElseThrow(() -> new EntryNotFoundException("Entrada não encontrada"));
        entryModel.setCodEntry(uuid);
        entryRepository.save(entryModel);
        return entryModel;
    }

    public UUID delete(UUID uuid) {
        var entryModel = entryRepository.findById(uuid).orElseThrow(() -> new EntryNotFoundException("Entrada não encontrada"));
        entryRepository.delete(entryModel);
        return uuid;
    }

    public List<EntryModel> findEntryByShippingCompany(UUID uuid) {
        return entryRepository.findEntryModelByShippingCompanyModel(shippingCompanyRepository.findById(uuid)
                .orElseThrow(() -> new ShippingCompanyNotFoundException("Entrada da transportadora não encontrada.")));
    }
}
