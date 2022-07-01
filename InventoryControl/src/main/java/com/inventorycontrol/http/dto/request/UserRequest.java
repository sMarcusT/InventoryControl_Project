package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
public class UserRequest {

    @NotEmpty(message = "Informe o login.")
    private String login;

    @NotEmpty(message = "Informe a senha.")
    private String password;
}
