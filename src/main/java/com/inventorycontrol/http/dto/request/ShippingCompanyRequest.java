package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ShippingCompanyRequest {

    private String shippingCompany;

    private String address;

    private Integer num;

    private String district;

    private String cep;

    private String cnpj;

    private String ins;

    private String contact;

    private String tel;
}
