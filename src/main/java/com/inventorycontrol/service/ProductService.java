package com.inventorycontrol.service;

import com.inventorycontrol.exception.ProductNotFoundException;
import com.inventorycontrol.model.ProductModel;
import com.inventorycontrol.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductModel> findAll(){
        return productRepository.findAll();
    }

    public ProductModel findById(UUID uuid){
        return productRepository.findById(uuid).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
    }

    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public ProductModel update(ProductModel productModel, UUID uuid){
        productRepository.findById(uuid).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
        productModel.setCodProduct(uuid);
        productRepository.save(productModel);
        return productModel;
    }

    public UUID delete(UUID uuid){
        var produtoModel = productRepository.findById(uuid).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));
        productRepository.delete(produtoModel);
        return uuid;
    }
}
