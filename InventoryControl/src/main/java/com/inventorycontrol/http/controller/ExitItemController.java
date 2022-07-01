package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.response.ExitItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/exitItem")
@Validated
public class ExitItemController {

    private final ExitItemService exitItemService;

    @GetMapping("/all")
    public ResponseEntity<List<ExitItemResponse>> findAll() {
        return ResponseEntity.ok().body(ExitItemMapper.exitItemResponseList(exitItemService.findAll()));
    }

    @GetMapping("/{exitItemId}")
    public ResponseEntity<ExitItemResponse> findById(@PathVariable String exitItemId) {
        return ResponseEntity.ok().body(ExitItemMapper.toResponse(exitItemService.findById(UUID.fromString(exitItemId))));
    }

    @PostMapping("/create")
    public ResponseEntity<ExitItemResponse> save(@RequestBody @Valid ExitItemRequest exitItemRequest) {
        return ResponseEntity.ok().body(ExitItemMapper.toResponse(exitItemService.save(ExitItemMapper.toModel(exitItemRequest))));
    }

    @PutMapping("/{exitItemId}")
    public ResponseEntity<ExitItemResponse> update(@RequestBody @Valid ExitItemRequest exitItemRequest, @PathVariable String exitItemId) {
        return ResponseEntity.ok().body(ExitItemMapper.toResponse(exitItemService.update(ExitItemMapper.toModel(exitItemRequest), UUID.fromString(exitItemId))));
    }

    @DeleteMapping("/{exitItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String exitItemId) {
        return ResponseEntity.ok().body(exitItemService.delete(UUID.fromString(exitItemId)));
    }
}
