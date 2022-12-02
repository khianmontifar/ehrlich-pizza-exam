package com.exam.ehrlichpizzaexam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class PizzaRankDTO {
    private String pizza;
    private Integer totalSale;
    public PizzaRankDTO(){}

}
