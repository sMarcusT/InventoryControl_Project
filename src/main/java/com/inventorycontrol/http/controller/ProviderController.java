package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.mapper.ProviderMapper;
import com.inventorycontrol.http.dto.request.ProviderRequest;
import com.inventorycontrol.http.dto.response.ProviderResponse;
import com.inventorycontrol.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/provider")
@Validated
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("/all")
    public ResponseEntity<List<ProviderResponse>> findAll(){
        return ResponseEntity.ok().body(ProviderMapper.toResponseList(providerService.findAll()));
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> findById(@PathVariable String providerId){
        return ResponseEntity.ok().body(ProviderMapper.toResponse(providerService.findById(UUID.fromString(providerId))));
    }

    @PostMapping("/create")
    public ResponseEntity<ProviderResponse> save(@RequestBody @Valid ProviderRequest providerRequest){
        return ResponseEntity.ok().body(ProviderMapper.toResponse(providerService.save(ProviderMapper.toModel(providerRequest))));
    }

    @PutMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> update(@RequestBody ProviderRequest providerRequest, @PathVariable String providerId){
        return ResponseEntity.ok().body(ProviderMapper.toResponse(providerService.update(ProviderMapper.toModel(providerRequest), UUID.fromString(providerId))));
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<UUID> delete(@PathVariable String providerId){
        return ResponseEntity.ok().body(providerService.delete(UUID.fromString(providerId)));
    }

    @GetMapping("/findProvidersByCity/{cityId}")
    public ResponseEntity<List<ProviderResponse>> findProviderByCities(@PathVariable String cityId){
        return ResponseEntity.ok().body(ProviderMapper.toResponseList(providerService.findProviderByCities(UUID.fromString(cityId))));
    }
}
