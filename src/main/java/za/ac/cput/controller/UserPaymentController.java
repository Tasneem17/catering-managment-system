package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.entity.UserPayment;
import za.ac.cput.service.UserPaymentService;

import javax.validation.Valid;
import java.util.List;

public class UserPaymentController {
    private final UserPaymentService userPaymentService;

    @Autowired
    public UserPaymentController(UserPaymentService userPaymentService) {
        this.userPaymentService = userPaymentService;

    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<UserPayment> save (@Valid @RequestBody UserPayment  userPayment) {
        //log.info("Save request: {}", userPayment);
        UserPayment obj;
        UserPayment save = userPaymentService.save( userPayment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{type}")
    public ResponseEntity<UserPayment> read(@PathVariable String  userPayment) {
        // log.info("Read request:{}", userPayment);
        UserPayment userPaymentType =  this.userPaymentService.read( userPayment)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND," UserPayment not found"));
        return ResponseEntity.ok( userPaymentType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String  userPayment) {
        this.userPaymentService.deleteByuserPayment( userPayment);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<UserPayment>> findAll() {
        List<UserPayment>  userPaymentType = this.userPaymentService.findAll();
        return ResponseEntity.ok( userPaymentType);
    }
}