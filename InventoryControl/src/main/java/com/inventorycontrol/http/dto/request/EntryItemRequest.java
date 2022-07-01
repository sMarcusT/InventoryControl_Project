package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class EntryItemRequest {

    @NotEmpty(message = "Informe o lote.")
    private String batch;

    @NotNull(message = "Informe a quantidade.")
    private Integer qtde;

    @NotNull(message = "Informe o valor.")
    private BigDecimal value;

    private UUID codProduct;

    private UUID codEntry;
}
