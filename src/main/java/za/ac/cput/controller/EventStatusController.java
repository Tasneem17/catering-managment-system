package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.service.impl.EventStatusServiceImpl;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/EventStatus")
@Slf4j
public class EventStatusController {
    private EventStatusServiceImpl eventStatusServiceimpl;

    @Autowired
    public EventStatusController(EventStatusServiceImpl eventStatusServiceimpl) {
        this.eventStatusServiceimpl = eventStatusServiceimpl;
    }

    @PostMapping("/Save")
    //implementation of the controller
    public ResponseEntity<EventStatus> save (@Valid @RequestBody EventStatus eventStatus) {
        log.info("Save request: {}",eventStatus);
        return ResponseEntity.ok(
                this.eventStatusServiceimpl.save(eventStatus)
        );

    }

    @GetMapping("/read/{type}")
    public ResponseEntity<EventStatus> read(@PathVariable String eventStatus) {
        log.info("Read request:{}",eventStatus);
        EventStatus eventStatusType =  this.eventStatusServiceimpl.read(eventStatus)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Event ID not found"));
        return ResponseEntity.ok(eventStatusType);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.eventStatusServiceimpl.deleteByid(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventStatus>> findAll() {
        List<EventStatus> eventStatusType = this.eventStatusServiceimpl.findAll();
        return ResponseEntity.ok(eventStatusType);
    }
}