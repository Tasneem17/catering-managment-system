package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.UserContact;
import za.ac.cput.service.UserContactService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/UserContact")
@Slf4j
public class UserContactController {
    private UserContactService userContactService;

    @Autowired

    public  UserContactController(UserContactService userContactService)
    {
        this.userContactService =userContactService;
    }

    @PostMapping("save")
    public ResponseEntity<UserContact> save (@RequestBody @Valid UserContact userContact){
        log.info("Save request:{}",userContact);
        UserContact saved = this.userContactService.save(userContact);
        return  ResponseEntity.ok(saved);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}",id);
        this.userContactService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<UserContact>>findall(UserContact userContact){
        log.info("Readall request:{}",userContact);
        List<UserContact>userContactAll = this.userContactService.findAll();
        return ResponseEntity.ok(userContactAll);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<UserContact>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        UserContact userContactRead = this.userContactService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(userContactRead);
    }



}
