package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
