package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Payment;
import za.ac.cput.entity.UserPayment;
import za.ac.cput.service.impl.PaymentServiceimpl;
import za.ac.cput.service.impl.UserPaymentServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/Payment")
@Slf4j
public class UserPaymentController {
    private UserPaymentServiceimpl userpaymentServiceimpl;

    @Autowired
    public UserPaymentController(UserPaymentServiceimpl userpaymentServiceimpl)
    {this.userpaymentServiceimpl = userpaymentServiceimpl;}

    @PostMapping("Save")
    public ResponseEntity<UserPayment> save (@Valid @RequestBody UserPayment userpayment) {
        log.info("Save request: {}",userpayment);
        UserPayment save = userpaymentServiceimpl.save(userpayment);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{type}")
    public ResponseEntity<UserPayment> read(@PathVariable String payment) {
        log.info("Read request:{}",payment);
        UserPayment paymentType =  this.userpaymentServiceimpl.read(payment)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"payment not found"));
        return ResponseEntity.ok(paymentType);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.userpaymentServiceimpl.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<UserPayment>> findAll() {
        List<UserPayment> paymentType = this.userpaymentServiceimpl.findAll();
        return ResponseEntity.ok(paymentType);
    }

}
