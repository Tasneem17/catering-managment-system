package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Food;
import za.ac.cput.service.impl.FoodServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/food")
@Slf4j
public class FoodController {
    private FoodServiceImpl foodImpl;

    @Autowired
    public  FoodController(FoodServiceImpl foodImpl)
    {
        this.foodImpl =foodImpl;
    }

    @PostMapping("/save")
    public Food save(@RequestBody @Valid Food food){
        log.info("Save request:{}",food);

        return  this.foodImpl.save(food);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deletebyid(@PathVariable String id){
        log.info("Read request:{}",id);
        return   this.foodImpl.deletebyid(id);
    }
    @GetMapping("/all")
    public List<Food> findAll(){
        return this.foodImpl.findAll();
    }


    @GetMapping("/read{id}")
    public Food read(@PathVariable String id){
        log.info("Read request:{}",id);
        return  this.foodImpl.read(id) ;
    }



}
