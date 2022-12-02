package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.helper.PizzaCSVHelper;
import com.exam.ehrlichpizzaexam.helper.PizzaTypesCSVHelper;
import com.exam.ehrlichpizzaexam.model.Pizza;
import com.exam.ehrlichpizzaexam.model.PizzaType;
import com.exam.ehrlichpizzaexam.persistence.PizzaRepository;
import com.exam.ehrlichpizzaexam.persistence.PizzaTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaRepository repository;
    public void save(MultipartFile file) {
        log.info("Processing save for Pizza");
        try {
            List<Pizza> tutorials = PizzaCSVHelper.csvPizzas(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

//    public Iterable<Pizza> getAllPizzas() {
//        return repository.findAll();
//    }
}
