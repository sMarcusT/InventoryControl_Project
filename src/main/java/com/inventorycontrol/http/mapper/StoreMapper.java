package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.StoreRequest;
import com.inventorycontrol.http.dto.response.StoreResponse;
import com.inventorycontrol.model.StoreModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class StoreMapper {

    public static StoreModel toModel(StoreRequest storeRequest){
        return StoreModel.builder()
                .name(storeRequest.getName())
                .address(storeRequest.getAddress())
                .num(storeRequest.getNum())
                .district(storeRequest.getDistrict())
                .cep(storeRequest.getCep())
                .cnpj(storeRequest.getCnpj())
                .insc(storeRequest.getInsc())
                .contact(storeRequest.getContact())
                .tel(storeRequest.getTel())
                .build();
    }

    public static StoreResponse toResponse(StoreModel storeModel){
        return StoreResponse.builder()
                .codStore(storeModel.getCodStore())
                .name(storeModel.getName())
                .address(storeModel.getAddress())
                .num(storeModel.getNum())
                .district(storeModel.getDistrict())
                .cep(storeModel.getCep())
                .cnpj(storeModel.getCnpj())
                .insc(storeModel.getInsc())
                .contact(storeModel.getContact())
                .tel(storeModel.getTel())
                .build();
    }

    public static List<StoreResponse> storeResponseList(List<StoreModel> storeModelList){
        if(isNull (storeModelList) || storeModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return storeModelList.stream().map(StoreMapper::toResponse).collect(Collectors.toList());
        }
    }
}
