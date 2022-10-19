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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Category")
@Slf4j
        public class CategoryController {

        private CategoryService categoryService;
        @Autowired
        public CategoryController (CategoryService categoryService)
        {
         this.categoryService =categoryService;
        }
        @PostMapping("save")
        public ResponseEntity<Category> save (@RequestBody @Valid Category category){
                log.info("Save request:{}",category);
                Category saved = this.categoryService.save(category);
                return  ResponseEntity.ok(saved);
        }
        @DeleteMapping("delete/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id){
                log.info("Read request:{}",id);
                this.categoryService.deletebyid(id);
                return ResponseEntity.noContent().build();
        }
        @GetMapping("all")
        public ResponseEntity<List<Category>>findall(Category category) {
                log.info("Readall request:{}", category);
                List<Category> categoryall = this.categoryService.findall(category);
                return ResponseEntity.ok(categoryall);
        }
        @GetMapping("read{id}")
        public  ResponseEntity<Category>read(@PathVariable @Validated String id){
                log.info("Read request:{}",id);
                Category categoryread = this.categoryService.read(id).orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                return ResponseEntity.ok(categoryread);
        }
}
