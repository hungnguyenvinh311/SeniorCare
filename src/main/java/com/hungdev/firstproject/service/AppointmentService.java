package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    void creatAppointment(AppointmentDTO dto);
    void cancelAppointment(Integer appointmentID);

    List<AppointmentDTO> getUserAppointments(Integer userId);

    AppointmentDTO updateAppointment(AppointmentDTO dto);
}
