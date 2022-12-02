/**
 * This controller provides endpoints display all analytic-related
 * data
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.controller;

import com.exam.ehrlichpizzaexam.converters.PizzaRankConverter;
import com.exam.ehrlichpizzaexam.model.PizzaOrdersView;
import com.exam.ehrlichpizzaexam.model.dto.DatePizzaDTO;
import com.exam.ehrlichpizzaexam.model.dto.PizzaRankDTO;
import com.exam.ehrlichpizzaexam.service.AnalyticService;
import com.exam.ehrlichpizzaexam.service.PizzaOrderViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/analytic")
public class AnalyticController {
    @Autowired
    private AnalyticService service;
    /**
     * This is the endpoint for getting the most popular pizza by ranking
     *
     */
    @Autowired
    private PizzaOrderViewService pizzaOrderViewService;
    @GetMapping("/rankPizza")
    public List<PizzaRankDTO> getAllPizzaTypes(){
        return PizzaRankConverter.convertToPizzaRank(service.rankPizzaByPopularity());
    }
    /**
     * This is the endpoint for getting the most number of days with its most popular pizza
     *
     */
    @GetMapping("/popularPizzaByDate")
    public List<DatePizzaDTO> getAllPizzaByDate(){
        return service.getPOpularPizzaByDate();
    }

    /**
     * This is the endpoint for viewing all the data in the database
     *
     */
    @GetMapping("/all")
    public List<PizzaOrdersView> getAllPizzaOrders(){
        return pizzaOrderViewService.getAllOrders();
    }
}
