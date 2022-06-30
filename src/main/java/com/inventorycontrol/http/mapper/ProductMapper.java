package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.ProductRequest;
import com.inventorycontrol.http.dto.response.ProductResponse;
import com.inventorycontrol.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ProductMapper {

    public static ProductModel toModel(ProductRequest productRequest) {
        return ProductModel.builder()
                .description(productRequest.getDescription())
                .weight(productRequest.getWeight())
                .controlled(productRequest.isControlled())
                .qtdMin(productRequest.getQtdMin())
                .build();
    }

    public static ProductResponse toResponse(ProductModel productModel) {
        return ProductResponse.builder()
                .codProduct(productModel.getCodProduct())
                .description(productModel.getDescription())
                .weight(productModel.getWeight())
                .controlled(productModel.isControlled())
                .qtdMin(productModel.getQtdMin())
                .build();
    }

    public static List<ProductResponse> produtoResponseList(List<ProductModel> productModelList) {
        if (isNull(productModelList) || productModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return productModelList.stream().map(ProductMapper::toResponse).collect(Collectors.toList());
        }
    }
}
