/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Controller :Decor
 */

package za.ac.cput.controller;



import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Decor;
import za.ac.cput.service.DecorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/Decor")
public class DecorController {
    private final DecorService decorService;


    @Autowired
    public DecorController(DecorService DecorService) {
        this.decorService = DecorService;
    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<Decor> save (@Valid @RequestBody Decor decor) {
        //log.info("Save request: {}",decor);
        Decor obj;
        Decor save = decorService.save(decor);
        return ResponseEntity.ok(save);

    }



    @GetMapping("read/{type}")
    public ResponseEntity<Decor> read(@PathVariable String decorType) {
        //log.info("Read request:{}",decorType);
        Decor decorrType =  this.decorService.read(decorType)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found"));
        return ResponseEntity.ok(decorrType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String decorType) {
        this.decorService.deleteBydecorType(decorType);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Decor>> findAll() {
        List<Decor> DecorTypes = this.decorService.findAll();
        return ResponseEntity.ok(DecorTypes);
    }
}




