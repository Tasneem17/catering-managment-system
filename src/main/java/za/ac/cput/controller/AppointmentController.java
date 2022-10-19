package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Appointment;
import za.ac.cput.service.impl.AppointmentServiceimpl;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("catering/management/system/Appointment")
    @Slf4j
    public class AppointmentController {
        private final AppointmentServiceimpl appointmentServiceimpl;

        @Autowired
        public AppointmentController(AppointmentServiceimpl appointmentServiceimpl) {
            this.appointmentServiceimpl = appointmentServiceimpl;
        }

        @PostMapping("Save")
        //implementation of the controller
        public ResponseEntity<Appointment> save (@Valid @RequestBody Appointment appointment) {
            log.info("Save request: {}",appointment);
            Appointment save = appointmentServiceimpl.save(appointment);
            return ResponseEntity.ok(save);
        }

        @GetMapping("read/{type}")
        public ResponseEntity<Appointment> read(@PathVariable String appointment) {
            log.info("Read request:{}",appointment);
            Appointment appointmentType =  this.appointmentServiceimpl.read(appointment)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment ID not found"));
            return ResponseEntity.ok(appointmentType);

        }


        @DeleteMapping("delete/{type}")
        public ResponseEntity <Void> delete(@PathVariable String id) {
            log.info("Read request:{}",id);
            this.appointmentServiceimpl.deleteById(id);
            return  ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<Appointment>> findAll() {
            List<Appointment>appointmentType = this.appointmentServiceimpl.findAll();
            return ResponseEntity.ok(appointmentType);
        }

    }
