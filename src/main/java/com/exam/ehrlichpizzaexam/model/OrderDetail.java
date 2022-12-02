package com.exam.ehrlichpizzaexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @Column(name = "order_details_id")
    private long order_details_id;

    @Column(name = "order_id")
    private long order_id;

    @Column(name = "pizza_id")
    private String pizza_id;

    @Column(name = "quantity")
    private Integer quantity;
}
