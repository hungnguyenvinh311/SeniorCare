package com.hungdev.firstproject.model;

import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private Integer appointmentId;
    private Integer userId;
    private Integer doctorId;
    private LocalDateTime appointmentTime;
    private String userSymptoms;
    private String status;
    private String doctorNotes;


    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getUserSymptoms() {
        return userSymptoms;
    }

    public void setUserSymptoms(String userSymptoms) {
        this.userSymptoms = userSymptoms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }
}
