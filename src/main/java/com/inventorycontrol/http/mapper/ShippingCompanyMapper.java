package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.ShippingCompanyRequest;
import com.inventorycontrol.http.dto.response.ShippingCompanyResponse;
import com.inventorycontrol.model.ShippingCompanyModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ShippingCompanyMapper {

    public static ShippingCompanyModel toModel(ShippingCompanyRequest shippingCompanyRequest) {
        return ShippingCompanyModel.builder()
                .shippingCompany(shippingCompanyRequest.getShippingCompany())
                .address(shippingCompanyRequest.getAddress())
                .num(shippingCompanyRequest.getNum())
                .district(shippingCompanyRequest.getDistrict())
                .cep(shippingCompanyRequest.getCep())
                .cnpj(shippingCompanyRequest.getCnpj())
                .ins(shippingCompanyRequest.getIns())
                .contact(shippingCompanyRequest.getContact())
                .tel(shippingCompanyRequest.getTel())
                .build();
    }

    public static ShippingCompanyResponse toResponse(ShippingCompanyModel shippingCompanyModel) {
        return ShippingCompanyResponse.builder()
                .codShippingCompany(shippingCompanyModel.getCodShippingCompany())
                .shippingCompany(shippingCompanyModel.getShippingCompany())
                .address(shippingCompanyModel.getAddress())
                .num(shippingCompanyModel.getNum())
                .district(shippingCompanyModel.getDistrict())
                .cep(shippingCompanyModel.getCep())
                .cnpj(shippingCompanyModel.getCnpj())
                .ins(shippingCompanyModel.getIns())
                .contact(shippingCompanyModel.getContact())
                .tel(shippingCompanyModel.getTel())
                .build();
    }

    public static List<ShippingCompanyResponse> shippingCompanyResponseList(List<ShippingCompanyModel> shippingCompanyModelList) {
        if (isNull(shippingCompanyModelList) || shippingCompanyModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return shippingCompanyModelList.stream().map(ShippingCompanyMapper::toResponse).collect(Collectors.toList());
        }
    }
}
