package com.exam.ehrlichpizzaexam.helper;

import com.exam.ehrlichpizzaexam.model.PizzaType;
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
    public static List<PizzaType> csvPizzaTypes(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<PizzaType> pizzaTypes = new ArrayList<PizzaType>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                PizzaType pizzaType = new PizzaType(
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
