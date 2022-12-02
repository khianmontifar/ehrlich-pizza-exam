/**
 * This services provides all the implementations for any
 * order detail related processing
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.helper.OrderCSVHelper;
import com.exam.ehrlichpizzaexam.helper.OrderDetailsCSVHelper;
import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.OrderDetail;
import com.exam.ehrlichpizzaexam.persistence.OrderDetailRepository;
import com.exam.ehrlichpizzaexam.persistence.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;
    public void save(MultipartFile file) {
        log.info("Processing save for OrderDetail");
        try {
            List<OrderDetail> tutorials = OrderDetailsCSVHelper.csvOrders(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<OrderDetail> getAllOrderDetails() {
        return repository.findAll();
    }
}
