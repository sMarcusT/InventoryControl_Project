package com.inventorycontrol.service;

import com.inventorycontrol.exception.OutputNotFoundException;
import com.inventorycontrol.model.OutputItemModel;
import com.inventorycontrol.repository.OutputItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OutputItemService {

    private final OutputItemRepository outputItemRepository;

    public List<OutputItemModel> findAll() {
        return outputItemRepository.findAll();
    }

    public OutputItemModel findById(UUID uuid) {
        return outputItemRepository.findById(uuid).orElseThrow(() -> new OutputNotFoundException("Item de saída não encontrado!"));
    }

    public OutputItemModel save(OutputItemModel outputItemModel) {
        return outputItemRepository.save(outputItemModel);
    }

    public OutputItemModel update(OutputItemModel outputItemModel, UUID uuid) {
        outputItemRepository.findById(uuid).orElseThrow(() -> new OutputNotFoundException("Item de saída não encontrado!"));
        outputItemModel.setCodOutputItem(uuid);
        outputItemRepository.save(outputItemModel);
        return outputItemModel;
    }

    public UUID delete(UUID uuid) {
        var outputItemModel = outputItemRepository.findById(uuid).orElseThrow(() -> new OutputNotFoundException("Item de saída não encontrado!"));
        outputItemRepository.delete(outputItemModel);
        return uuid;
    }
}
