package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
public class StoreRequest {

    @NotEmpty(message = "Informe o name.")
    private String name;

    @NotEmpty(message = "Informe o endereço.")
    private String address;

    @NotNull(message = "Informe o número.")
    private Integer num;

    @NotEmpty(message = "Informe o bairro.")
    private String district;

    @NotEmpty(message = "Informe o telefone.")
    @Size(min = 14, max = 14)
    private String tel;

    @NotEmpty(message = "Informe a insc.")
    private String insc;

    @NotEmpty(message = "Informe o CNPJ.")
    @CNPJ
    private String cnpj;

    private UUID codCity;
}
