package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "exit", schema = "inventory")
public class ExitModel {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codExit;

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    // Imposto
    private BigDecimal tax;

    @ManyToOne
    @JoinColumn(name = "store_codStore")
    private StoreModel storeModel;

    @ManyToOne
    @JoinColumn(name = "shippingCompany_codShippingCompany")
    private ShippingCompanyModel shippingCompanyModel;
}
