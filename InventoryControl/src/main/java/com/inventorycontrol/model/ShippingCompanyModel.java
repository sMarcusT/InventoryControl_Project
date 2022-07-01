package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "shipping_company", schema = "inventory")
public class ShippingCompanyModel implements Serializable {

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

    @ManyToMany
    @JoinTable(
            name = "shipping_company_cities",
            schema = "inventory",
            joinColumns = @JoinColumn(name = "cod_codShippingCompany_fk"),
            inverseJoinColumns = @JoinColumn(name = "cod_codCity-fk"))
    private List<CityModel> cityModelList;
}
