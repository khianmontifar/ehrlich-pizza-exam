package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.OrderDetails;
import com.exam.ehrlichpizzaexam.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
}
