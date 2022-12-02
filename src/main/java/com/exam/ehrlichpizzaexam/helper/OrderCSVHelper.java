package com.exam.ehrlichpizzaexam.helper;

import com.exam.ehrlichpizzaexam.model.Order;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderCSVHelper extends BaseCSVHelper{
    public static List<Order> csvOrders(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Order> orders = new ArrayList<Order>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Order order = new Order(
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
