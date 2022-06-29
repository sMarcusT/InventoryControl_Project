package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.dto.request.ShippingCompanyRequest;
import com.inventorycontrol.http.dto.response.ShippingCompanyResponse;
import com.inventorycontrol.http.mapper.ShippingCompanyMapper;
import com.inventorycontrol.service.ShippingCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/shippingCompany")
@Validated
public class ShippingCompanyController {

    private final ShippingCompanyService shippingCompanyService;

    @GetMapping("/all")
    public ResponseEntity<List<ShippingCompanyResponse>> findAll(){
        return ResponseEntity.ok().body(ShippingCompanyMapper.shippingCompanyResponseList(shippingCompanyService.findAll()));
    }

    @GetMapping("/{shippingCompanyId}")
    public ResponseEntity<ShippingCompanyResponse> findById(@PathVariable String shippingCompanyId){
        return ResponseEntity.ok().body(ShippingCompanyMapper.toResponse(shippingCompanyService.findById(UUID.fromString(shippingCompanyId))));
    }

    @PostMapping("/create")
    public ResponseEntity<ShippingCompanyResponse> save(@RequestBody @Valid ShippingCompanyRequest shippingCompanyRequest){
        return ResponseEntity.ok().body(ShippingCompanyMapper.toResponse(shippingCompanyService.save(ShippingCompanyMapper.toModel(shippingCompanyRequest))));
    }

    @PutMapping("/{shippingCompanyId}")
    public ResponseEntity<ShippingCompanyResponse> update(@RequestBody ShippingCompanyRequest shippingCompanyRequest, @PathVariable String shippingCompanyId){
        return ResponseEntity.ok().body(ShippingCompanyMapper.toResponse(shippingCompanyService.update(ShippingCompanyMapper.toModel(shippingCompanyRequest), UUID.fromString(shippingCompanyId))));
    }

    @DeleteMapping("/{shippingCompanyId}")
    public ResponseEntity<UUID> delete(@PathVariable String shippingCompanyId){
        return ResponseEntity.ok().body(shippingCompanyService.delete(UUID.fromString(shippingCompanyId)));
    }
}
