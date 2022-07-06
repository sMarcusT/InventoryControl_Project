package com.inventorycontrol.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StoreResponse {

    private UUID codStore;

    private String name;

    private String address;

    private Integer num;

    private String district;

    private String tel;

    private String insc;

    private String cnpj;
}
