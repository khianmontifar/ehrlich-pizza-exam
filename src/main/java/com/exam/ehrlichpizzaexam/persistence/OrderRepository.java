package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.dto.PizzaRankDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value="SELECT distinct(o.date) from Order o ORDER BY o.date ASC")
    List<LocalDate> fetchAllDistinctDate();

}
