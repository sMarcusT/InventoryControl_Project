package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {

    private String name;

    private String address;

    private Integer num;

    private String district;

    private String cep;

    private String cnpj;

    private String insc;

    private String contact;

    private String tel;
}
