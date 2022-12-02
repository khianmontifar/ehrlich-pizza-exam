package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
