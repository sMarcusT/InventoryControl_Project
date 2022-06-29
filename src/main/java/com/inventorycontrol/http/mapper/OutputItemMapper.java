package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.OutputItemRequest;
import com.inventorycontrol.http.dto.response.OutputItemResponse;
import com.inventorycontrol.model.OutputItemModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class OutputItemMapper {

    public static OutputItemModel toModel(OutputItemRequest outputItemRequest){
        return OutputItemModel.builder()
                .batch(outputItemRequest.getBatch())
                .qtde(outputItemRequest.getQtde())
                .value(outputItemRequest.getValue())
                .build();
    }

    public static OutputItemResponse toResponse(OutputItemModel outputItemModel){
        return OutputItemResponse.builder()
                .codOutputItem(outputItemModel.getCodOutputItem())
                .batch(outputItemModel.getBatch())
                .qtde(outputItemModel.getQtde())
                .value(outputItemModel.getValue())
                .build();
    }

    public static List<OutputItemResponse> outputItemResponseList(List<OutputItemModel> outputItemModelList){
        if(isNull(outputItemModelList) || outputItemModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return outputItemModelList.stream().map(OutputItemMapper::toResponse).collect(Collectors.toList());
        }
    }
}
