package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.ExitItemRequest;
import com.inventorycontrol.http.dto.response.ExitItemResponse;
import com.inventorycontrol.model.ExitItemModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ExitItemMapper {

    public static ExitItemModel toModel(ExitItemRequest exitItemRequest) {
        return ExitItemModel.builder()
                .batch(exitItemRequest.getBatch())
                .qtde(exitItemRequest.getQtde())
                .value(exitItemRequest.getValue())
                .build();
    }

    public static ExitItemResponse toResponse(ExitItemModel exitItemModel) {
        return ExitItemResponse.builder()
                .codExitItem(exitItemModel.getCodExitItem())
                .batch(exitItemModel.getBatch())
                .qtde(exitItemModel.getQtde())
                .value(exitItemModel.getValue())
                .build();
    }

    public static List<ExitItemResponse> exitItemResponseList(List<ExitItemModel> exitItemModelList) {
        if (isNull(exitItemModelList) || exitItemModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return exitItemModelList.stream().map(ExitItemMapper::toResponse).collect(Collectors.toList());
        }
    }
}
