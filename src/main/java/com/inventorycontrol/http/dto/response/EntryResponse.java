package com.inventorycontrol.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EntryResponse {

    private UUID codEntry;

    private Date requestDate;

    private Date entryDate;

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    private Integer num;

    // Imposto
    private BigDecimal tax;
}
