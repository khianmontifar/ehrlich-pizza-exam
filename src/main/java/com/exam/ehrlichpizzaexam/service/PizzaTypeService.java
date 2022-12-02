package com.exam.ehrlichpizzaexam.service;

import com.exam.ehrlichpizzaexam.helper.PizzaTypesCSVHelper;
import com.exam.ehrlichpizzaexam.model.PizzaType;
import com.exam.ehrlichpizzaexam.persistence.PizzaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PizzaTypeService {
    @Autowired
    private PizzaTypeRepository repository;
    public void save(MultipartFile file) {
        try {
            List<PizzaType> tutorials = PizzaTypesCSVHelper.csvPizzaTypes(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<PizzaType> getAllTutorials() {
        return repository.findAll();
    }
}
