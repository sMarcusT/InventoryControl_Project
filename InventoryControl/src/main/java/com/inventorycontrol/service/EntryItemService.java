package com.inventorycontrol.service;

import com.inventorycontrol.exception.ProductNotFoundException;
import com.inventorycontrol.model.EntryItemModel;
import com.inventorycontrol.repository.EntryItemRepository;
import com.inventorycontrol.exception.EntryItemNotFoundException;
import com.inventorycontrol.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EntryItemService {

    private final EntryItemRepository entryItemRepository;

    private final ProductRepository productRepository;

    public List<EntryItemModel> findAll() {
        return entryItemRepository.findAll();
    }

    public EntryItemModel findById(UUID uuid) {
        return entryItemRepository.findById(uuid).orElseThrow(() -> new EntryItemNotFoundException("Entrada de item não encontrada"));
    }

    public EntryItemModel save(EntryItemModel entryItemModel) {
        return entryItemRepository.save(entryItemModel);
    }

    public EntryItemModel update(EntryItemModel entryItemModel, UUID uuid) {
        entryItemRepository.findById(uuid).orElseThrow(() -> new EntryItemNotFoundException("Entrada de item não encontrada"));
        entryItemModel.setCodeEntryItem(uuid);
        entryItemRepository.save(entryItemModel);
        return entryItemModel;
    }

    public UUID delete(UUID uuid) {
        var entryItemModel = entryItemRepository.findById(uuid).orElseThrow(() -> new EntryItemNotFoundException("Entrada de item não encontrada"));
        entryItemRepository.delete(entryItemModel);
        return uuid;
    }

    public List<EntryItemModel> findItemEntryByProduct(UUID uuid) {
        return entryItemRepository.findEntryItemModelByProductModel(productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado.")));
    }
}
