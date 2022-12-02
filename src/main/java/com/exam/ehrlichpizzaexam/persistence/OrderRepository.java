package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
