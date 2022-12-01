package com.exam.ehrlichpizzaexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizzas {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "pizza")
    private String pizza;

    @Column(name = "pizza_type_id")
    private long pizza_type_id;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private BigDecimal price;
}
