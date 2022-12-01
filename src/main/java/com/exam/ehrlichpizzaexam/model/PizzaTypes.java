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
@Table(name = "pizza_types")
public class PizzaTypes {

    @Id
    @Column(name = "pizza_type_id")
    private String pizzaTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "ingredients")
    private String ingredients;
}
