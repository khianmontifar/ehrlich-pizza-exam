/**
 * This services provides all the implementations for analytic-related
 * processing
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.model.Order;
import com.exam.ehrlichpizzaexam.model.OrderDetail;
import com.exam.ehrlichpizzaexam.model.PizzaOrdersView;
import com.exam.ehrlichpizzaexam.model.dto.DatePizzaDTO;
import com.exam.ehrlichpizzaexam.model.dto.PizzaRankDTO;
import com.exam.ehrlichpizzaexam.persistence.OrderDetailRepository;
import com.exam.ehrlichpizzaexam.persistence.OrderRepository;
import com.exam.ehrlichpizzaexam.persistence.PizzaOrderViewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AnalyticService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Autowired
    private PizzaOrderViewRepository viewRepository;

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    /**
     * This method process the ranking of pizza by popularity
     *
     */
    public Map<String, Integer> rankPizzaByPopularity(){
        return viewRepository.findAll().stream().collect(Collectors.groupingBy(PizzaOrdersView::getName,
                        Collectors.summingInt(PizzaOrdersView::getQuantity)));

    }

    public List<PizzaOrdersView> findByPopularity(){
        List<PizzaOrdersView> viewList = viewRepository.findAll();
        Map<String, Integer> map = viewList.stream()
                .collect(Collectors.groupingBy(PizzaOrdersView::getName,
                        Collectors.summingInt(PizzaOrdersView::getQuantity)));

        return viewList.stream().sorted(
                        Comparator.comparing((PizzaOrdersView x)->map.get(x.getName()))
                                .thenComparing(PizzaOrdersView::getQuantity).reversed())
                .collect(Collectors.toList());
    }
    /**
     * This method process the view for getting the popular dates with
     * popular pizza
     *
     */
    public List<DatePizzaDTO> getPOpularPizzaByDate(){
        List<DatePizzaDTO> datePizzaDTOList = new ArrayList<>();

        List<PizzaOrdersView> viewList = viewRepository.findAll();

        Map<LocalDate, Integer> dateRankMap = viewList.stream()
                .collect(Collectors.groupingBy(PizzaOrdersView::getDate,
                        Collectors.summingInt(PizzaOrdersView::getQuantity)));
        Set<LocalDate> dateKeys = dateRankMap.keySet();
        dateKeys.stream().forEach(date->{
            DatePizzaDTO datePizzaDTO = new DatePizzaDTO();
            List<PizzaOrdersView> sortedList = viewList.stream().filter(view->view.getDate()==date).sorted(
                            Comparator.comparing((PizzaOrdersView x)->dateRankMap.get(x.getDate()))
                                    .thenComparing(PizzaOrdersView::getQuantity).reversed())
                    .collect(Collectors.toList());
            datePizzaDTO.setDate(date);
            datePizzaDTO.setPizzaName(sortedList.get(0).getName());
            datePizzaDTOList.add(datePizzaDTO);
        });

        return datePizzaDTOList;

    }
}
