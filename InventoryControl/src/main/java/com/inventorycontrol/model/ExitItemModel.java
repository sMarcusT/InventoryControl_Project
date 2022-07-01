package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "exit_item", schema = "inventory")
public class ExitItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codExitItem;

    private String batch;

    private Integer qtde;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "exit_codExit")
    private ExitModel exitModel;
}
