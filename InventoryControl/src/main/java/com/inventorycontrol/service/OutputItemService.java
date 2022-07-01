package com.inventorycontrol.service;

import com.inventorycontrol.exception.ExitNotFoundException;
import com.inventorycontrol.exception.OutputNotFoundException;
import com.inventorycontrol.exception.ProductNotFoundException;
import com.inventorycontrol.model.OutputItemModel;
import com.inventorycontrol.repository.ExitRepository;
import com.inventorycontrol.repository.OutputItemRepository;
import com.inventorycontrol.repository.ProductRepository;
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

    private final ProductRepository productRepository;

    private final ExitRepository exitRepository;

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

    public List<OutputItemModel> findItemOutputByProduct(UUID uuid){
        return outputItemRepository.findOutputItemModelByProductModel(productRepository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado.")));
    }
}
