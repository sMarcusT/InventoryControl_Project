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
public class ProductResponse {

    private UUID codProduct;

    private String description;

    private Double weight;

    private boolean controlled;

    private Integer qtdMin;
}
