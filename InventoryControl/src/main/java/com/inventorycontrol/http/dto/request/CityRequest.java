package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CityRequest {

    @NotEmpty(message = "Informe a cidade.")
    private String city;

    @NotEmpty(message = "Informe a UF(Unidade Federativa).")
    @Size(min = 2, max = 2)
    private String uf;
}
