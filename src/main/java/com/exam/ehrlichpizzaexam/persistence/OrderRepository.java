package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.Orders;
import com.exam.ehrlichpizzaexam.model.PizzaTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
