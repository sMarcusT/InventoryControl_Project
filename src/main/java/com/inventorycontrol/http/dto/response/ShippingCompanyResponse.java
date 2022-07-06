package com.inventorycontrol.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShippingCompanyResponse {

    private UUID codShippingCompany;

    private String shippingCompany;

    private String address;

    private Integer num;

    private String district;

    private String cep;

    private String cnpj;

    private String ins;

    private String contact;

    private String tel;

    private List<CityResponse> cityResponseList;
}
