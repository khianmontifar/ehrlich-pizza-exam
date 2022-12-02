package com.exam.ehrlichpizzaexam.helper;

import com.exam.ehrlichpizzaexam.model.OrderDetail;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsCSVHelper extends BaseCSVHelper{
    public static List<OrderDetail> csvOrders(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                OrderDetail orderDetail = new OrderDetail(
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
