package com.inventorycontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@Table(name = "product", schema = "inventory")
public class ProductModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codProduct;

    private String description;

    private Double weight;

    private boolean controlled;

    private Integer qtdMin;

    @ManyToOne
    @JoinColumn(name = "category_codCategory")
    private CategoryModel categoryModel;
}
