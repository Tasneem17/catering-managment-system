package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Event;
import za.ac.cput.service.EventService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/Event")
@Slf4j
public class EventController {
    private EventService eventService;
    @Autowired

    public  EventController(EventService eventService)
    {
        this.eventService =eventService;
    }


    @PostMapping("save")
    public ResponseEntity<Event> save (@RequestBody @Valid Event event){
        return ResponseEntity.ok(
                this.eventService.save(event)
        );
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}",id);
        this.eventService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Event>>findAll(Event event){
        log.info("Readall request:{}",event);
        List<Event>eventAll = this.eventService.findAll();
        return ResponseEntity.ok(eventAll);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<Event>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        Event eventRead = this.eventService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(eventRead);
    }



}
