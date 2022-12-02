package com.exam.ehrlichpizzaexam.helper;

import com.exam.ehrlichpizzaexam.model.Pizza;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PizzaCSVHelper extends BaseCSVHelper{
    public static List<Pizza> csvPizzas(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Pizza> pizzas = new ArrayList<Pizza>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Pizza pizza = new Pizza(
                        csvRecord.get("pizza_id"),
                        csvRecord.get("pizza_type_id"),
                        csvRecord.get("size"),
                        new BigDecimal(csvRecord.get("price")));
                pizzas.add(pizza);
            }

            return pizzas;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
