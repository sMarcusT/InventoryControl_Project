package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ExitRequest {

    @NotNull(message = "Informe o valor total.")
    private BigDecimal total;

    // Frete
    @NotNull(message = "Informe o valor do frete.")
    private BigDecimal shipping;

    // Imposto
    @NotNull(message = "Informe o valor do imposto sobre o produto.")
    private BigDecimal tax;

    private UUID codStore;
}
