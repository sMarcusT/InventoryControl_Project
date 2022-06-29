package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.EntryRequest;
import com.inventorycontrol.http.dto.response.EntryResponse;
import com.inventorycontrol.model.EntryModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class EntryMapper {

    public static EntryModel toModel(EntryRequest entryRequest){
        return EntryModel.builder()
                .requestDate(entryRequest.getRequestDate())
                .entryDate(entryRequest.getEntryDate())
                .total(entryRequest.getTotal())
                .shipping(entryRequest.getShipping())
                .num(entryRequest.getNum())
                .tax(entryRequest.getTax())
                .build();
    }

    public static EntryResponse toResponse(EntryModel entryModel){
        return EntryResponse.builder()
                .codEntry(entryModel.getCodEntry())
                .requestDate(entryModel.getRequestDate())
                .entryDate(entryModel.getEntryDate())
                .total(entryModel.getTotal())
                .shipping(entryModel.getShipping())
                .num(entryModel.getNum())
                .tax(entryModel.getTax())
                .build();
    }

    public static List<EntryResponse> entryResponseList(List<EntryModel> entryModelList){
        if(isNull(entryModelList) || entryModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return entryModelList.stream().map(EntryMapper::toResponse).collect(Collectors.toList());
        }
    }
}
