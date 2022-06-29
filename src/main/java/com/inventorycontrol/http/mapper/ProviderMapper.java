package com.inventorycontrol.http.mapper;

import com.inventorycontrol.model.CityModel;
import com.inventorycontrol.model.ProviderModel;
import com.inventorycontrol.http.dto.request.ProviderRequest;
import com.inventorycontrol.http.dto.response.ProviderResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ProviderMapper {

    public static ProviderModel toModel(ProviderRequest providerRequest){
        return ProviderModel.builder()
                .provider(providerRequest.getProvider())
                .address(providerRequest.getAddress())
                .num(providerRequest.getNum())
                .district(providerRequest.getDistrict())
                .cep(providerRequest.getCep())
                .contact(providerRequest.getContact())
                .cnpj(providerRequest.getCnpj())
                .insc(providerRequest.getInsc())
                .tel(providerRequest.getTel())
                .cityModel(CityModel.builder().codCity(providerRequest.getCodCity()).build())
                .build();
    }

    public static ProviderResponse toResponse(ProviderModel providerModel){
        return ProviderResponse.builder()
                .codProvider(providerModel.getCodProvider())
                .provider(providerModel.getProvider())
                .address(providerModel.getAddress())
                .num(providerModel.getNum())
                .district(providerModel.getDistrict())
                .cep(providerModel.getCep())
                .cnpj(providerModel.getCnpj())
                .contact(providerModel.getContact())
                .insc(providerModel.getInsc())
                .tel(providerModel.getTel())
                .build();
    }

    public static List<ProviderResponse> toResponseList(List<ProviderModel> providerModelList){
        if(isNull(providerModelList) || providerModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return providerModelList.stream().map(ProviderMapper::toResponse).collect(Collectors.toList());
        }
    }
}
