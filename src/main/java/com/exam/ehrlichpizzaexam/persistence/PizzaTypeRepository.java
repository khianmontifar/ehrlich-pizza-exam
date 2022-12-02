package com.exam.ehrlichpizzaexam.persistence;

import com.exam.ehrlichpizzaexam.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType,Long> {
}
