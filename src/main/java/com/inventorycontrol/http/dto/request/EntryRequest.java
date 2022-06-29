package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EntryRequest {

    private Date requestDate;

    private Date entryDate;

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    private Integer num;

    // Imposto
    private BigDecimal tax;
}
