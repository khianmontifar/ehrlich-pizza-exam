package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaTypes;
import com.exam.ehrlichpizzaexam.model.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizzas,Long> {
    List<Pizzas> findByPizza(String pizza);
}
