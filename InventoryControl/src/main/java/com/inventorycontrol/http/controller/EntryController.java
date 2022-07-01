package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.EntryRequest;
import com.inventorycontrol.http.dto.response.EntryResponse;
import com.inventorycontrol.http.mapper.EntryMapper;
import com.inventorycontrol.service.EntryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/entry")
@Validated
public class EntryController {

    private final EntryService entryService;

    @GetMapping("/all")
    public ResponseEntity<List<EntryResponse>> findAll() {
        return ResponseEntity.ok().body(EntryMapper.entryResponseList(entryService.findAll()));
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<EntryResponse> findById(@PathVariable String entryId) {
        return ResponseEntity.ok().body(EntryMapper.toResponse(entryService.findById(UUID.fromString(entryId))));

    }

    @PostMapping("/create")
    public ResponseEntity<EntryResponse> save(@RequestBody @Valid EntryRequest entryRequest) {
        return ResponseEntity.ok().body(EntryMapper.toResponse(entryService.save(EntryMapper.toModel(entryRequest))));
    }

    @PutMapping("/{entryId}")
    public ResponseEntity<EntryResponse> update(@RequestBody @Valid EntryRequest entryRequest, @PathVariable String entryId) {
        return ResponseEntity.ok().body(EntryMapper.toResponse(entryService.update(EntryMapper.toModel(entryRequest), UUID.fromString(entryId))));
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<UUID> delete(@PathVariable String entryId) {
        return ResponseEntity.ok().body(entryService.delete(UUID.fromString(entryId)));
    }
}
