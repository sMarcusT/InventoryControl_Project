package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OutputItemRequest {

    // Lote
    private String batch;

    private Integer qtde;

    private BigDecimal value;
}
