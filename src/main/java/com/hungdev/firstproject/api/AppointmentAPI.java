package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.AppointmentDTO;
import com.hungdev.firstproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Transactional
public class AppointmentAPI {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public void creatAppointment(@RequestBody AppointmentDTO dto){
        appointmentService.creatAppointment(dto);
    }

    @PostMapping("/cancel")
    public void cancelAppointment(@RequestParam Integer appointmentId){
        appointmentService.cancelAppointment(appointmentId);
    }


    @GetMapping("/user")
    public List<AppointmentDTO> getAllUserAppointments(@RequestParam Integer userId){
        List<AppointmentDTO> dtos = appointmentService.getUserAppointments(userId);
        return dtos;
    }

    @PutMapping
    public AppointmentDTO updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentDTO updatedAppointment = appointmentService.updateAppointment(appointmentDTO);
        return updatedAppointment;
    }


}
