package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.service.EventStatusService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering/management/system/EventStatus")
public class EventStatusController {
    private final EventStatusService eventStatusService;

    @Autowired
    public EventStatusController(EventStatusService eventStatusService) {
        this.eventStatusService = eventStatusService;

    }

    @PostMapping("Save")
    //implementation of the controller
    public ResponseEntity<EventStatus> save (@Valid @RequestBody EventStatus eventStatus) {
        //log.info("Save request: {}",eventStatus);
        EventStatus obj;
        EventStatus save = eventStatusService.save(eventStatus);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{type}")
    public ResponseEntity<EventStatus> read(@PathVariable String eventStatus) {
        // log.info("Read request:{}",eventStatus);
        EventStatus eventStatusType =  this.eventStatusService.read(eventStatus)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Event ID not found"));
        return ResponseEntity.ok(eventStatusType);

    }


    @DeleteMapping("delete/{type}")
    public ResponseEntity <Void> delete(@PathVariable String eventStatus) {
        this.eventStatusService.deleteByeventStatus(eventStatus);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EventStatus>> findAll() {
        List<EventStatus> eventStatusType = this.eventStatusService.findAll();
        return ResponseEntity.ok(eventStatusType);
    }
}