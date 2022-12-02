package com.exam.ehrlichpizzaexam.controller;

import com.exam.ehrlichpizzaexam.helper.PizzaCSVHelper;
import com.exam.ehrlichpizzaexam.helper.PizzaTypesCSVHelper;
import com.exam.ehrlichpizzaexam.message.ResponseMessage;
import com.exam.ehrlichpizzaexam.model.Pizza;
import com.exam.ehrlichpizzaexam.model.PizzaType;
import com.exam.ehrlichpizzaexam.service.PizzaService;
import com.exam.ehrlichpizzaexam.service.PizzaTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/pizza")
public class PizzaController {
    @Autowired
    PizzaService pizzaService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (PizzaCSVHelper.hasCSVFormat(file)) {
            try {
                pizzaService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
//    @GetMapping("/pizzas")
//    public List<Pizza> getAllPizzaTypes(){
//        return pizzaService.getAllPizzas().forEach(a->a.);
//    }

}
