package com.inventorycontrol.service;

import com.inventorycontrol.exception.CategoryNotFoundException;
import com.inventorycontrol.exception.ProviderNotFoundException;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.repository.CategoryRepository;
import com.inventorycontrol.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final ProviderRepository providerRepository;

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel findById(UUID uuid) {
        return categoryRepository.findById(uuid).orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
    }

    public CategoryModel save(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    public CategoryModel update(CategoryModel categoryModel, UUID uuid) {
        categoryRepository.findById(uuid).orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
        categoryModel.setCodCategory(uuid);
        categoryRepository.save(categoryModel);
        return categoryModel;
    }

    public UUID delete(UUID uuid) {
        var categoryModel = categoryRepository.findById(uuid).orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
        categoryRepository.delete(categoryModel);
        return uuid;
    }

    public List<CategoryModel> findCategoriesByProvider(UUID uuid) {
        return categoryRepository.findCategoryModelByProviderModel(providerRepository.findById(uuid)
                .orElseThrow(() -> new ProviderNotFoundException("Fornecedor não encontrado.")));
    }
}
