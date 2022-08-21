package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Food;
import za.ac.cput.service.FoodService;
import za.ac.cput.service.impl.FoodServiceImpl;

import javax.validation.Valid;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;


@RestController
@RequestMapping("/Food")
@Slf4j
public class FoodController {
    private FoodService foodService;

    @Autowired

    public  FoodController(FoodService foodService)
    {
        this.foodService =foodService;
    }

    @PostMapping("save")
    public ResponseEntity<Food> save (@RequestBody @Valid Food food){
        log.info("Save request:{}",food);
        Food saved = this.foodService.save(food);
        return  ResponseEntity.ok(saved);
    }
    @DeleteMapping("delete/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}",id);
        this.foodService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Food>>findall(Food food){
        log.info("Readall request:{}",food);
        List<Food>foodall = this.foodService.findall(food);
        return ResponseEntity.ok(foodall);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<Food>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        Food foodread = this.foodService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(foodread);
    }



}
