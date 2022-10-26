package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Category;
import za.ac.cput.entity.UserPayment;
import za.ac.cput.service.impl.UserPaymentServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/UserPayment")
@Slf4j
public class UserPaymentController {
    private UserPaymentServiceimpl userpaymentServiceimpl;

    @Autowired
    public UserPaymentController(UserPaymentServiceimpl userpaymentServiceimpl)
    {this.userpaymentServiceimpl = userpaymentServiceimpl;}

    @PostMapping("/Save")
    public ResponseEntity<UserPayment> save (@Valid @RequestBody UserPayment userpayment) {
        log.info("Save request: {}",userpayment);
        return ResponseEntity.ok(
                this.userpaymentServiceimpl.save(userpayment)
        );

    }
    @GetMapping("/read/{id}")
    public UserPayment read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        return this.userpaymentServiceimpl.read(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.userpaymentServiceimpl.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public List<UserPayment> findAll() {
        return this.userpaymentServiceimpl.findAll();
    }

}
