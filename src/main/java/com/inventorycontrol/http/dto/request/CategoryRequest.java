package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryRequest {

    @NotEmpty(message = "Informe a categoria.")
    private String category;
}
