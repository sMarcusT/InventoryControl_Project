package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.ExitRequest;
import com.inventorycontrol.http.dto.response.ExitResponse;
import com.inventorycontrol.http.mapper.ExitMapper;
import com.inventorycontrol.service.ExitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/exit")
@Validated
public class ExitController {

    private final ExitService exitService;

    @GetMapping("/all")
    public ResponseEntity<List<ExitResponse>> findAll(){
        return ResponseEntity.ok().body(ExitMapper.toResponseList(exitService.findAll()));
    }

    @GetMapping("/{exitId}")
    public ResponseEntity<ExitResponse> findById(@PathVariable String exitId){
        return ResponseEntity.ok().body(ExitMapper.toResponse(exitService.findById(UUID.fromString(exitId))));
    }

    @PostMapping("/create")
    public ResponseEntity<ExitResponse> save(@RequestBody @Valid ExitRequest exitRequest){
        return ResponseEntity.ok().body(ExitMapper.toResponse(exitService.save(ExitMapper.toModel(exitRequest))));
    }

    @PutMapping("/{exitId}")
    public ResponseEntity<ExitResponse> update(@RequestBody ExitRequest exitRequest, @PathVariable String exitId){
        return ResponseEntity.ok().body(ExitMapper.toResponse(exitService.update(ExitMapper.toModel(exitRequest), UUID.fromString(exitId))));
    }

    @DeleteMapping("{exitId}")
    public ResponseEntity<UUID> delete(@PathVariable String exitId){
        return ResponseEntity.ok().body(exitService.delete(UUID.fromString(exitId)));
    }
}
