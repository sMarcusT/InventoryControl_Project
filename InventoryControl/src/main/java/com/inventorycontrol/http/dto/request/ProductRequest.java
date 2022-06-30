package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    @NotEmpty(message = "Informe a descrição do produto.")
    private String description;

    @NotNull(message = "Informe o peso.")
    private Double weight;

    private boolean controlled;

    @NotNull(message = "Informe o quantidade minima.")
    private Integer qtdMin;

    private UUID codCategory;
}
