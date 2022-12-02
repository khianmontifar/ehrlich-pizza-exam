package com.exam.ehrlichpizzaexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.time.LocalDate;
@Data
@Entity
@Immutable
@Table(name = "v_pizzaorders")
@Subselect("select uuid_generate_v1() as id, po.* from v_pizzaorders po")
public class PizzaOrdersView {
    @Id
    private String id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "quantity")
    private Integer quantity;
}
