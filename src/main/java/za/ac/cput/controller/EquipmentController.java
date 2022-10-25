/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Controller :Equipment
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Equipment;
import za.ac.cput.service.EquipmentService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("catering/management/system/Equipment")
@Slf4j
public class EquipmentController {
    private final EquipmentService equipmentService;



    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<Equipment> save (@Valid @RequestBody Equipment equipment) {
        log.info("Save request: {}",equipment);
        Equipment obj;
        Equipment save = equipmentService.save(equipment);
        return ResponseEntity.ok(save);

    }



    @GetMapping("read/{type}")
    public ResponseEntity<Equipment> read(@PathVariable String equipmentID) {
        log.info("Read request:{}",equipmentID);
        Equipment equipmentType =  this.equipmentService.read(equipmentID)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found"));
        return ResponseEntity.ok(equipmentType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String equipmentID) {
        this.equipmentService.deleteByequipmentID(equipmentID);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Equipment>> findAll() {
        List<Equipment> equipmentType = this.equipmentService.findAll();
        return ResponseEntity.ok(equipmentType);
    }
}




