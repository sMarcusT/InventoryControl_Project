package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
public class CategoryRequest {

    @NotEmpty(message = "Informe a categoria.")
    private String category;

    private UUID codProvider;
}
