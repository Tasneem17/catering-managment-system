package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Payment;
import za.ac.cput.service.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/Payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<Payment> save (@Valid @RequestBody Payment payment) {
        //log.info("Save request: {}",payment);
        Payment obj;
        Payment save = paymentService.save(payment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Payment> read(@PathVariable String payment) {
        // log.info("Read request:{}",payment);
        Payment paymentType =  this.paymentService.read(payment)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"payment not found"));
        return ResponseEntity.ok(paymentType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String payment) {
        this.paymentService.deleteBypayment(payment);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> paymentType = this.paymentService.findAll();
        return ResponseEntity.ok(paymentType);
    }

}
