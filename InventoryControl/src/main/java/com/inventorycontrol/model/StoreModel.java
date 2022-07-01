package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "store", schema = "inventory")
public class StoreModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codStore;

    private String name;

    private String address;

    private Integer num;

    private String district;

    private String tel;

    private String insc;

    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "city_codCity")
    private CityModel cityModel;
}
