package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaTypeRepository extends JpaRepository<PizzaType,Long> {
}
