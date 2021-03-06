package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "output_item", schema = "inventory")
public class OutputItemModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codOutputItem;

    // Lote
    private String batch;

    private Integer qtde;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "product_codProduct")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "exit_codExit")
    private ExitModel exitModel;
}
