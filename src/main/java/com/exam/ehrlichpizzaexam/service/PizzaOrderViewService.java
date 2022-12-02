/**
 * This services provides all the implementations for any
 * displaying the view of all pizza order data
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
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
