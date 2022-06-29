package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.EntryItemRequest;
import com.inventorycontrol.http.dto.response.EntryItemResponse;
import com.inventorycontrol.http.mapper.EntryItemMapper;
import com.inventorycontrol.service.EntryItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/entryitem")
public class EntryItemController {

    private final EntryItemService entryItemService;

    @GetMapping("/all")
    public ResponseEntity<List<EntryItemResponse>> findAll() {
        return ResponseEntity.ok().body(EntryItemMapper.toResponseList(entryItemService.findAll()));
    }

    @GetMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> findById(@PathVariable String entryItemId) {
        return ResponseEntity.ok().body(EntryItemMapper.toResponse(entryItemService.findById(UUID.fromString(entryItemId))));
    }

    @PostMapping("/create")
    public ResponseEntity<EntryItemResponse> save(@RequestBody EntryItemRequest entryItemRequest) {
        return ResponseEntity.ok().body(EntryItemMapper.toResponse(entryItemService.save(EntryItemMapper.toModel(entryItemRequest))));
    }

    @PutMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> update(@RequestBody EntryItemRequest entryItemRequest, @PathVariable String entryItemId) {
        return ResponseEntity.ok().body(EntryItemMapper.toResponse(entryItemService.update(EntryItemMapper.toModel(entryItemRequest), UUID.fromString(entryItemId))));
    }

    @DeleteMapping("{entryItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String entryItemId) {
        return ResponseEntity.ok().body(entryItemService.delete(UUID.fromString(entryItemId)));
    }
}
