package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Appointment;
import za.ac.cput.service.impl.AppointmentService;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("catering/management/system/Appointment")
    public class AppointmentController {
        private final AppointmentService appointmentService;

        @Autowired
        public AppointmentController(AppointmentService appointmentService) {
            this.appointmentService = appointmentService;

        }

        @PostMapping("Save")
        //implementation of the controller
        public ResponseEntity<Appointment> save (@Valid @RequestBody Appointment appointment) {
            //log.info("Save request: {}",appointment);
            Appointment obj;
            Appointment save = appointmentService.save(appointment);
            return ResponseEntity.ok(save);
        }

        @GetMapping("read/{type}")
        public ResponseEntity<Appointment> read(@PathVariable String appointment) {
            // log.info("Read request:{}",appointment);
            Appointment appointmentType =  this.appointmentService.read(appointment)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment ID not found"));
            return ResponseEntity.ok(appointmentType);

        }


        @DeleteMapping("delete/{type}")
        public ResponseEntity <Void> delete(@PathVariable String appointment) {
            this.appointmentService.deleteByappointment(appointment);
            return  ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<Appointment>> findAll() {
            List<Appointment>appointmentType = this.appointmentService.findAll();
            return ResponseEntity.ok(appointmentType);
        }

    }
