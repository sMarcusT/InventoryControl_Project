package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "entry", schema = "inventory")
public class EntryModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codEntry;

    private LocalDateTime requestDate;

    private LocalDateTime entryDate;

    private BigDecimal total;

    // Frete
    private BigDecimal shipping;

    private Integer num;

    // Imposto
    private BigDecimal tax;

    @ManyToOne
    @JoinColumn(name = "shippingCompany_codShippingCompany")
    private ShippingCompanyModel shippingCompanyModel;
}
