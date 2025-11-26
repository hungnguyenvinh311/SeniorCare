package com.hungdev.firstproject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PrescriptionDTO {
    private Integer appointmentId;
    private Integer userId;
    private Integer doctorId;
    private String medicationName;
    private String dosage;
    private String instructions;
    private LocalDate startDate;
    private Integer durationDays;

    // Danh sách giờ uống trong ngày (Ví dụ: ["08:00", "14:00", "20:00"])
    private List<LocalTime> dailyTimes;

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public List<LocalTime> getDailyTimes() {
        return dailyTimes;
    }

    public void setDailyTimes(List<LocalTime> dailyTimes) {
        this.dailyTimes = dailyTimes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
