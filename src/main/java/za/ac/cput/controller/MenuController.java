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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Menu")
@Slf4j
public class MenuController {
    private MenuService menuService;
    @Autowired
    public MenuController(MenuService menuService){
        this.menuService =menuService;
    }
    @PostMapping("save")
    public ResponseEntity<Menu>save(@RequestBody @Valid Menu menu){
        log.info("Save request:{}",menu);
        Menu saved = this.menuService.save(menu);
        return ResponseEntity.ok(saved);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.menuService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Menu>>findall(Menu menu){
        log.info("Readall request:{}",menu);
        List<Menu>menuall = this.menuService.findall(menu);
        return ResponseEntity.ok(menuall);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<Menu>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        Menu menuread = this.menuService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(menuread);
    }
}
