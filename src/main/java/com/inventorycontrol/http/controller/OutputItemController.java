package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.OutputItemRequest;
import com.inventorycontrol.http.dto.response.OutputItemResponse;
import com.inventorycontrol.http.mapper.OutputItemMapper;
import com.inventorycontrol.service.OutputItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/outputitem")
@Validated
public class OutputItemController {

    private final OutputItemService outputItemService;

    @GetMapping("/all")
    public ResponseEntity<List<OutputItemResponse>> findAll(){
        return ResponseEntity.ok().body(OutputItemMapper.outputItemResponseList(outputItemService.findAll()));
    }

    @GetMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> findById(@PathVariable String outputItemId){
        return ResponseEntity.ok().body(OutputItemMapper.toResponse(outputItemService.findById(UUID.fromString(outputItemId))));
    }

    @PostMapping("/create")
    public ResponseEntity<OutputItemResponse> save(@RequestBody @Valid OutputItemRequest outputItemRequest){
        return ResponseEntity.ok().body(OutputItemMapper.toResponse(outputItemService.save(OutputItemMapper.toModel(outputItemRequest))));
    }

    @PutMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> update(@RequestBody OutputItemRequest outputItemRequest, @PathVariable String outputItemId){
        return ResponseEntity.ok().body(OutputItemMapper.toResponse(outputItemService.update(OutputItemMapper.toModel(outputItemRequest), UUID.fromString(outputItemId))));
    }

    @DeleteMapping("/{outputItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String outputItemId){
        return ResponseEntity.ok().body(outputItemService.delete(UUID.fromString(outputItemId)));
    }
}
