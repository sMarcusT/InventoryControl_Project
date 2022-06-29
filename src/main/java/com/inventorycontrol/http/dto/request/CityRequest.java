package com.inventorycontrol.http.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRequest {

    private String city;

    private String uf;
}
