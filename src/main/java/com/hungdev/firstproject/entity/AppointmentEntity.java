package com.hungdev.firstproject.entity;




import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;


    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime appointmentTime;


    @Column(name = "user_symptoms")
    private String userSymptoms;


    @Column(name = "status")
    private String status;


    @Column(name = "doctor_notes")
    private String doctorNotes;


    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrescriptionEntity> prescriptionEntities;

    public List<PrescriptionEntity> getPrescriptionEntities() {
        return prescriptionEntities;
    }

    public void setPrescriptionEntities(List<PrescriptionEntity> prescriptionEntities) {
        this.prescriptionEntities = prescriptionEntities;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }


    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }


    public UserEntity getUser() {
        return user;
    }


    public void setUser(UserEntity user) {
        this.user = user;
    }


    public DoctorEntity getDoctor() {
        return doctor;
    }


    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
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

