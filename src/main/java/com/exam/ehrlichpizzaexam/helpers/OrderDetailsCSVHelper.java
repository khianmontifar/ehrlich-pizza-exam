package com.exam.ehrlichpizzaexam.helpers;

import com.exam.ehrlichpizzaexam.model.OrderDetails;
import com.exam.ehrlichpizzaexam.model.Orders;
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

public class OrderDetailsCSVHelper extends BaseCSVHelper{
    public static List<OrderDetails> csvOrders(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                OrderDetails orderDetail = new OrderDetails(
                        Long.parseLong(csvRecord.get("order_details_id")),
                        Long.parseLong(csvRecord.get("order_id")),
                        csvRecord.get("pizza_id"),
                        Integer.parseInt(csvRecord.get("quantity")));
                orderDetails.add(orderDetail);
            }

            return orderDetails;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
