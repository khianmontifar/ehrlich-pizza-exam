/**
 * This services provides all the implementations for any
 * order related processing
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.helper.OrderCSVHelper;
import com.exam.ehrlichpizzaexam.helper.PizzaCSVHelper;
import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.Pizza;
import com.exam.ehrlichpizzaexam.persistence.OrderRepository;
import com.exam.ehrlichpizzaexam.persistence.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public void save(MultipartFile file) {
        log.info("Processing save for Order");
        try {
            List<Order> tutorials = OrderCSVHelper.csvOrders(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
