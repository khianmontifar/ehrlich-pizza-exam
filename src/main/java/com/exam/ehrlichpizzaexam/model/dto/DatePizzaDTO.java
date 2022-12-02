package com.exam.ehrlichpizzaexam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatePizzaDTO {
    private LocalDate date;
    private String pizzaName;
}
