package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EventTheme;
import za.ac.cput.service.EventThemeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/EventTheme")
@Slf4j
public class EventThemeController {
    private EventThemeService eventThemeService;
    @Autowired

    public  EventThemeController(EventThemeService eventThemeService)
    {
        this.eventThemeService =eventThemeService;
    }


    @PostMapping("save")
    public ResponseEntity<EventTheme> save (@RequestBody @Valid EventTheme eventTheme){
        return ResponseEntity.ok(
                this.eventThemeService.save(eventTheme)
        );
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}",id);
        this.eventThemeService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<EventTheme>>findAll(EventTheme eventTheme){
        log.info("Readall request:{}",eventTheme);
        List<EventTheme>eventThemeAll = this.eventThemeService.findAll();
        return ResponseEntity.ok(eventThemeAll);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<EventTheme>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        EventTheme eventThemeRead = this.eventThemeService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(eventThemeRead);
    }



}