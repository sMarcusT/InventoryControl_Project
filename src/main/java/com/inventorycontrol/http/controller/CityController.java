package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.CityRequest;
import com.inventorycontrol.http.dto.response.CityResponse;
import com.inventorycontrol.http.mapper.CityMapper;
import com.inventorycontrol.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<List<CityResponse>> findAll() {
        return ResponseEntity.ok().body(CityMapper.toResponseList(cityService.findAll()));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponse> findById(@PathVariable String cityId) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.findById(UUID.fromString(cityId))));
    }

    @PostMapping("/create")
    public ResponseEntity<CityResponse> save(@RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.save(CityMapper.toModel(cityRequest))));
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityResponse> update(@RequestBody CityRequest cityRequest, @PathVariable String cityId) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.update(CityMapper.toModel(cityRequest), UUID.fromString(cityId))));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<UUID> delete(@PathVariable String cityId) {
        return ResponseEntity.ok().body(cityService.delete(UUID.fromString(cityId)));
    }
}
