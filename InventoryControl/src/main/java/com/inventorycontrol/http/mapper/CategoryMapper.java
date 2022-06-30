package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.CategoryRequest;
import com.inventorycontrol.http.dto.response.CategoryResponse;
import com.inventorycontrol.model.CategoryModel;
import com.inventorycontrol.model.ProviderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class CategoryMapper {

    public static CategoryModel toModel(CategoryRequest categoryRequest) {
        return CategoryModel.builder()
                .category(categoryRequest.getCategory())
                .providerModel(ProviderModel.builder().codProvider(categoryRequest.getCodProvider()).build())
                .build();
    }

    public static CategoryResponse toResponse(CategoryModel categoryModel) {
        return CategoryResponse.builder()
                .codCategory(categoryModel.getCodCategory())
                .category(categoryModel.getCategory())
                .build();
    }

    public static List<CategoryResponse> toResponseList(List<CategoryModel> categoryModelList) {
        if (isNull(categoryModelList) || categoryModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return categoryModelList.stream().map(CategoryMapper::toResponse).collect(Collectors.toList());
        }
    }
}
