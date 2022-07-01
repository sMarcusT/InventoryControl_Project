package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.CategoryRequest;
import com.inventorycontrol.http.dto.response.CategoryResponse;
import com.inventorycontrol.http.mapper.CategoryMapper;
import com.inventorycontrol.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok().body(CategoryMapper.toResponseList(categoryService.findAll()));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable String categoryId) {
        return ResponseEntity.ok().body(CategoryMapper.toResponse(categoryService.findById(UUID.fromString(categoryId))));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> save(@RequestBody @Valid CategoryRequest categoryRequest) {
        return ResponseEntity.ok().body(CategoryMapper.toResponse(categoryService.save(CategoryMapper.toModel(categoryRequest))));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable String categoryId) {
        return ResponseEntity.ok().body(CategoryMapper.toResponse(categoryService.update(CategoryMapper.toModel(categoryRequest), UUID.fromString(categoryId))));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<UUID> delete(@PathVariable String categoryId) {
        return ResponseEntity.ok().body(categoryService.delete(UUID.fromString(categoryId)));
    }

    @GetMapping("/findCategoriesByProvider/{providerId}")
    public ResponseEntity<List<CategoryResponse>> findCategoriesByProvider(@PathVariable String providerId) {
        return ResponseEntity.ok().body(CategoryMapper.toResponseList(categoryService.findCategoriesByProvider(UUID.fromString(providerId))));
    }
}
