
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Payment;
import za.ac.cput.service.impl.PaymentServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/Payment")
@Slf4j
public class PaymentController {
    private PaymentServiceimpl paymentServiceimpl;

    @Autowired
    public PaymentController(PaymentServiceimpl paymentServiceimpl)
    {this.paymentServiceimpl = paymentServiceimpl;}

    @PostMapping("/Save")
    public ResponseEntity<Payment> save (@Valid @RequestBody Payment payment) {
        log.info("Save request: {}",payment);
        return ResponseEntity.ok(
                this.paymentServiceimpl.save(payment)
        );

    }

    @GetMapping("/read/{type}")
    public ResponseEntity<Payment> read(@PathVariable String payment) {
        log.info("Read request:{}",payment);
        Payment paymentType =  this.paymentServiceimpl.read(payment)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"payment not found"));
        return ResponseEntity.ok(paymentType);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.paymentServiceimpl.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> paymentType = this.paymentServiceimpl.findAll();
        return ResponseEntity.ok(paymentType);
    }

}
