package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.EventAppointment;
import za.ac.cput.service.EventAppointmentService;



import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/EventAppointment")
@Slf4j
public class EventAppointmentController {

    private EventAppointmentService eventAppointmentService;


    @Autowired

    public  EventAppointmentController(EventAppointmentService eventAppointmentService)
    {
        this.eventAppointmentService =eventAppointmentService;
    }
    @PostMapping("save")
    public ResponseEntity<EventAppointment> save (@RequestBody @Valid EventAppointment eventAppointment){
        return ResponseEntity.ok(
                this.eventAppointmentService.save(eventAppointment)
        );
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Read request:{}",id);
        this.eventAppointmentService.deletebyid(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<EventAppointment>>findAll(EventAppointment eventAppointment){
        log.info("Readall request:{}",eventAppointment);
        List<EventAppointment>eventAll = this.eventAppointmentService.findAll();
        return ResponseEntity.ok(eventAll);
    }
    @GetMapping("read{id}")
    public  ResponseEntity<EventAppointment>read(@PathVariable @Validated String id){
        log.info("Read request:{}",id);
        EventAppointment eventAppointmentRead = this.eventAppointmentService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(eventAppointmentRead);
    }



}