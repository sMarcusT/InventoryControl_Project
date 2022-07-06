package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.StoreRequest;
import com.inventorycontrol.http.dto.response.StoreResponse;
import com.inventorycontrol.http.mapper.StoreMapper;
import com.inventorycontrol.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/store")
@Validated
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/all")
    public ResponseEntity<List<StoreResponse>> findAll() {
        return ResponseEntity.ok().body(StoreMapper.storeResponseList(storeService.findAll()));
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreResponse> findById(@PathVariable String storeId) {
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.findById(UUID.fromString(storeId))));
    }

    @PostMapping("/create")
    public ResponseEntity<StoreResponse> save(@RequestBody @Valid StoreRequest storeRequest) {
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.save(StoreMapper.toModel(storeRequest))));
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<StoreResponse> update(@RequestBody @Valid StoreRequest storeRequest, @PathVariable String storeId) {
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.update(StoreMapper.toModel(storeRequest), UUID.fromString(storeId))));
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<UUID> delete(@PathVariable String storeId) {
        return ResponseEntity.ok().body(storeService.delete(UUID.fromString(storeId)));
    }

    @GetMapping("/findStoresByCity/{cityId}")
    public ResponseEntity<List<StoreResponse>> findStoresByCity(@PathVariable String cityId) {
        return ResponseEntity.ok().body(StoreMapper.storeResponseList(storeService.findStoresByCity(UUID.fromString(cityId))));
    }
}
