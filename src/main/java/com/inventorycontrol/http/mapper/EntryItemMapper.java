package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.EntryItemRequest;
import com.inventorycontrol.http.dto.response.EntryItemResponse;
import com.inventorycontrol.model.EntryItemModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class EntryItemMapper {

    public static EntryItemModel toModel(EntryItemRequest entryItemRequest){
        return EntryItemModel.builder()
                .batch(entryItemRequest.getBatch())
                .qtde(entryItemRequest.getQtde())
                .value(entryItemRequest.getValue())
                .build();
    }

    public static EntryItemResponse toResponse(EntryItemModel entryItemModel){
        return EntryItemResponse.builder()
                .codeEntryItem(entryItemModel.getCodeEntryItem())
                .batch(entryItemModel.getBatch())
                .qtde(entryItemModel.getQtde())
                .value(entryItemModel.getValue())
                .build();
    }

    public static List<EntryItemResponse> toResponseList(List<EntryItemModel> entryItemModelList){
        if(isNull(entryItemModelList) || entryItemModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return entryItemModelList.stream().map(EntryItemMapper::toResponse).collect(Collectors.toList());
        }
    }
}
