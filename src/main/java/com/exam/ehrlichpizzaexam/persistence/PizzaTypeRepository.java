package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaTypeRepository extends JpaRepository<PizzaTypes,Long> {
}
