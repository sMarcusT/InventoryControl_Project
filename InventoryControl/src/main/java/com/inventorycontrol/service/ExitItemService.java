package com.inventorycontrol.service;

import com.inventorycontrol.exception.ExitItemNotFoundException;
import com.inventorycontrol.model.ExitItemModel;
import com.inventorycontrol.repository.ExitItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ExitItemService {

    private final ExitItemRepository exitItemRepository;

    public List<ExitItemModel> findAll() {
        return exitItemRepository.findAll();
    }

    public ExitItemModel findById(UUID uuid) {
        return exitItemRepository.findById(uuid).orElseThrow(() -> new ExitItemNotFoundException("Item de saída não encontrado."));
    }

    public ExitItemModel save(ExitItemModel exitItemModel) {
        return exitItemRepository.save(exitItemModel);
    }

    public ExitItemModel update(ExitItemModel exitItemModel, UUID uuid) {
        exitItemRepository.findById(uuid).orElseThrow(() -> new ExitItemNotFoundException("Item de saída não encontrado."));
        exitItemModel.setCodExitItem(uuid);
        exitItemRepository.save(exitItemModel);
        return exitItemModel;
    }

    public UUID delete(UUID uuid) {
        var exitItemModel = exitItemRepository.findById(uuid).orElseThrow(() -> new ExitItemNotFoundException("Item de saída não encontrado."));
        exitItemRepository.delete(exitItemModel);
        return uuid;
    }
}
