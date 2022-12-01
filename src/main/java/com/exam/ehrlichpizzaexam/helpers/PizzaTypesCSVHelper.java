package com.exam.ehrlichpizzaexam.helpers;

import com.exam.ehrlichpizzaexam.model.PizzaTypes;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PizzaTypesCSVHelper extends BaseCSVHelper{
    public static List<PizzaTypes> csvPizzaTypes(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<PizzaTypes> pizzaTypes = new ArrayList<PizzaTypes>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                PizzaTypes pizzaType = new PizzaTypes(
                        csvRecord.get("pizza_type_id"),
                        csvRecord.get("name"),
                        csvRecord.get("category"),
                        csvRecord.get("ingredients"));
                pizzaTypes.add(pizzaType);
            }

            return pizzaTypes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
