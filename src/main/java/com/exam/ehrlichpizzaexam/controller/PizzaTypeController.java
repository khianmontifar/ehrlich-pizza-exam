/**
 * This controller provides endpoints to upload csv for pizza types
 * and display all uploaded data.
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.controller;

import com.exam.ehrlichpizzaexam.helper.PizzaTypesCSVHelper;
import com.exam.ehrlichpizzaexam.message.ResponseMessage;
import com.exam.ehrlichpizzaexam.model.PizzaType;
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
@RequestMapping("/api/pizzaType")
public class PizzaTypeController {
    @Autowired
    PizzaTypeService pizzaTypeService;

    /**
     * This is the endpoint for upload with RequestMethod POST
     *
     */
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (PizzaTypesCSVHelper.hasCSVFormat(file)) {
            try {
                pizzaTypeService.save(file);
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
    /**
     * This is the endpoint for fetching all pizza types
     *
     */
    @GetMapping("/pizzaTypes")
    public List<PizzaType> getAllPizzaTypes(){
        return pizzaTypeService.getAllPizzaType();
    }

}
