package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ExitRequest {

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    // Imposto
    private BigDecimal tax;
}
