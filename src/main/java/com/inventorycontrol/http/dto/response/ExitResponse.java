package com.inventorycontrol.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExitResponse {

    private UUID codExit;

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    // Imposto
    private BigDecimal tax;
}
