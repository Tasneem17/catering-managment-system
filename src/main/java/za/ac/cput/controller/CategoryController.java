package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Category;
import za.ac.cput.service.CategoryService;
import za.ac.cput.service.impl.CategoryServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@Slf4j
        public class CategoryController {

        private CategoryServiceImpl categoryImpl;
        @Autowired
        public CategoryController (CategoryServiceImpl categoryImpl)
        {
         this.categoryImpl =categoryImpl;
        }


        @PostMapping("/save")
        public ResponseEntity<Category> save (@RequestBody @Valid Category category){
                log.info("Save request:{}",category);
                return ResponseEntity.ok(
                        this.categoryImpl.save(category)
                );

        }
        @DeleteMapping("/delete/{id}")
        public boolean deletebyid(@PathVariable String id){
                log.info("Read request:{}",id);
                return   this.categoryImpl.deletebyid(id);
        }

        @GetMapping("/all")
        public List<Category> findAll() {
                return this.categoryImpl.findAll();
        }


        @GetMapping("/read/{id}")
        public Category read(@PathVariable @Validated String id){
                log.info("Read request:{}",id);
                return this.categoryImpl.read(id);
        }
}
