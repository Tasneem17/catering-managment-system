package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Menu;
import za.ac.cput.service.MenuService;
import za.ac.cput.service.impl.MenuServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    private MenuServiceImpl menuImpl;
    @Autowired
    public MenuController(MenuServiceImpl menuImpl){
        this.menuImpl =menuImpl;
    }
    @PostMapping("save")
    public Menu save(@RequestBody @Valid Menu menu){
        log.info("Save request:{}",menu);
        return  this.menuImpl.save(menu) ;
    }
    @DeleteMapping("delete/{id}")
    public boolean deletebyid(@PathVariable String id) {
        return  this.menuImpl.deletebyid(id);
    }
    @GetMapping("all")
    public List<Menu> findAll(){
        return  this.menuImpl.findAll();
    }
    @GetMapping("read{id}")
    public Menu read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        return this.menuImpl.read(id);
    }
}
