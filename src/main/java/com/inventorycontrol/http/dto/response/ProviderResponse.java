package com.inventorycontrol.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProviderResponse {

    private UUID codProvider;

    private String provider;

    private String address;

    private Integer num;

    private String district;

    private String cep;

    private String contact;

    private String cnpj;

    private String insc;

    private String tel;

    private String nameCity;
}
