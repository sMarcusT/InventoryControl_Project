package com.inventorycontrol.http.dto.request;

import io.swagger.v3.oas.annotations.info.Contact;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProviderRequest {

    @NotEmpty(message = "Informe o fornecedor.")
    private String provider;

    @NotEmpty(message = "Informe o endereço.")
    private String address;

    @NotNull(message = "Informe o número.")
    private Integer num;

    @NotEmpty(message = "Informe o bairro.")
    private String district;

    @NotEmpty(message = "Informe o CEP.")
    @Size(min = 9, max = 9)
    private String cep;

    @NotEmpty(message = "Informe o CNPJ.")
    @CNPJ
    private String cnpj;

    @NotEmpty(message = "Informe a insc.")
    private String insc;

    @NotEmpty(message = "Informe o contato.")
    private String contact;

    @NotEmpty(message = "Informe o telefone.")
    @Size(min = 14, max = 14)
    private String tel;

    private List<UUID> codCityList;
}
