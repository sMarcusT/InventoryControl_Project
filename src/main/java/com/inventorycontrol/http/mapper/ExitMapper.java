package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.ExitRequest;
import com.inventorycontrol.http.dto.response.ExitResponse;
import com.inventorycontrol.model.ExitModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ExitMapper {

    public static ExitModel toModel(ExitRequest exitRequest){
        return ExitModel.builder()
                .total(exitRequest.getTotal())
                .shipping(exitRequest.getShipping())
                .tax(exitRequest.getTax())
                .build();
    }

    public static ExitResponse toResponse(ExitModel exitModel){
        return ExitResponse.builder()
                .codExit(exitModel.getCodExit())
                .total(exitModel.getTotal())
                .shipping(exitModel.getShipping())
                .tax(exitModel.getTax())
                .build();
    }

    public static List<ExitResponse> toResponseList(List<ExitModel> exitModelList){
        if(isNull(exitModelList) || exitModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return exitModelList.stream().map(ExitMapper::toResponse).collect(Collectors.toList());
        }
    }
}
