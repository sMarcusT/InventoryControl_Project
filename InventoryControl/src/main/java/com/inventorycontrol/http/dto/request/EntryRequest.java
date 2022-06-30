package com.inventorycontrol.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class EntryRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @NotEmpty(message = "Informe a data do pedido.")
    private LocalDateTime requestDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @NotEmpty(message = "Informe a data de entrada.")
    private LocalDateTime entryDate;

    @NotNull(message = "Informe o valor total.")
    private BigDecimal total;

    // Frete
    @NotNull(message = "Informe o valor do frete.")
    private BigDecimal shipping;

    @NotNull(message = "Informe o numero.")
    private Integer num;

    // Imposto
    @NotEmpty(message = "Informe o valor do imposto sobre o produto.")
    private BigDecimal tax;
}
