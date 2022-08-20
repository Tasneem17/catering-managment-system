/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Controller :BeverageMenu
 */
package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.service.BeverageMenuService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/BeverageMenu")
public class BeverageMenuController {
    private final BeverageMenuService beverageMenuService;



    @Autowired
    public BeverageMenuController(BeverageMenuService beverageMenuService) {
        this.beverageMenuService = beverageMenuService;
    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<BeverageMenu> save (@Valid @RequestBody BeverageMenu beverageMenu) {
        //log.info("Save request: {}",beverageMenu);
        BeverageMenu obj;
        BeverageMenu save = beverageMenuService.save(beverageMenu);
        return ResponseEntity.ok(save);

    }



    @GetMapping("read/{type}")
    public ResponseEntity<BeverageMenu> read(@PathVariable String beverageName) {
       // log.info("Read request:{}",beverageName);
        BeverageMenu beverageMenuType =  this.beverageMenuService.read(beverageName)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found"));
        return ResponseEntity.ok(beverageMenuType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String beverageName) {
        this.beverageMenuService.deleteBybeverageName(beverageName);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<BeverageMenu>> findAll() {
        List<BeverageMenu> beverageMenuType = this.beverageMenuService.findAll();
        return ResponseEntity.ok(beverageMenuType);
    }
}






