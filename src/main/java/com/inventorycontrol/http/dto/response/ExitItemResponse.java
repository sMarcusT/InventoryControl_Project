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
public class ExitItemResponse {

    private UUID codExitItem;

    private String batch;

    private Integer qtde;

    private BigDecimal value;
}
