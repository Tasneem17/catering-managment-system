/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Controller :Equipment Choice
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.service.EquipmentChoiceService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("catering/management/system/EquipmentChoice")
public class EquipmentChoiceController {
    private final EquipmentChoiceService equipmentChoiceService;



    @Autowired
    public EquipmentChoiceController(EquipmentChoiceService equipmentChoiceService) {
        this.equipmentChoiceService = equipmentChoiceService;
    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<EquipmentChoice> save (@Valid @RequestBody EquipmentChoice equipmentChoice) {
        //log.info("Save request: {}",equipmentChoice);
        EquipmentChoice obj;
        EquipmentChoice save = equipmentChoiceService.save(equipmentChoice);
        return ResponseEntity.ok(save);

    }



    @GetMapping("read/{type}")
    public ResponseEntity<EquipmentChoice> read(@PathVariable String choiceCustomer) {
        //log.info("Read request:{}",choiceCustomer);
        EquipmentChoice equipmentChoiceType =  this.equipmentChoiceService.read(choiceCustomer)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found"));
        return ResponseEntity.ok(equipmentChoiceType);


    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String choiceCustomer) {
        this.equipmentChoiceService.deleteBychoiceCustomer(choiceCustomer);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EquipmentChoice>> findAll() {
        List<EquipmentChoice> equipmentChoiceType = this.equipmentChoiceService.findAll();
        return ResponseEntity.ok(equipmentChoiceType);
    }
}


