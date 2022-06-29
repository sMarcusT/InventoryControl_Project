package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String description;

    private Double weight;

    private boolean controlled;

    private Integer qtdMin;
}
