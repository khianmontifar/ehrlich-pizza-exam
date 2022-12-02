package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.PizzaOrdersView;
import com.exam.ehrlichpizzaexam.persistence.PizzaOrderViewRepository;
import com.exam.ehrlichpizzaexam.persistence.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaOrderViewService {
    @Autowired
    private PizzaOrderViewRepository repository;

    public List<PizzaOrdersView> getAllOrders() {
        return repository.findAll();
    }
}
