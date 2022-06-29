package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "shipping_company", schema = "inventory")
public class ShippingCompanyModel {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codShippingCompany;

    private String shippingCompany;

    private String address;

    private Integer num;

    private String district;

    private String cep;

    private String cnpj;

    private String ins;

    private String contact;

    private String tel;
}
