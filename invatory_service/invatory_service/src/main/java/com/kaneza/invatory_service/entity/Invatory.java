package com.kaneza.invatory_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="invatory1")
public class Invatory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "SkuCode",nullable = false, unique = true)
    private String skuCode;

    @Column(name= "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Category", nullable = false)
    private String category;


}
