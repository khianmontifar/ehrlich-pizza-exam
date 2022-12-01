package com.exam.ehrlichpizzaexam.helpers;

import com.exam.ehrlichpizzaexam.model.Orders;
import com.exam.ehrlichpizzaexam.model.Pizzas;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderCSVHelper extends BaseCSVHelper{
    public static List<Orders> csvOrders(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Orders> orders = new ArrayList<Orders>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Orders order = new Orders(
                        Long.parseLong(csvRecord.get("order_id")),
                        LocalDate.parse(csvRecord.get("date")),
                        LocalTime.parse(csvRecord.get("time")));
                orders.add(order);
            }

            return orders;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
