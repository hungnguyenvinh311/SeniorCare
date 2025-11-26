package com.hungdev.firstproject.entity;




import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Doctors")
public class DoctorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;


    @Column(name = "full_name",  nullable = false)
    private String fullName;


    @Column(name = "workplace")
    private String workplace;


    @Column(name = "position")
    private String position;


    @Column(name = "specialization")
    private String specialization;


    @Column(name = "rating")
    private Float rating;


    @Column(name = "profile_picture_url")
    private String profilePictureUrl;


    @Column(name = "bio")
    private String bio;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Appointments",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> userEntities = new ArrayList<>();


    @OneToMany(
            mappedBy = "doctor", // "doctor" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AppointmentEntity> appointments = new ArrayList<>();

    @OneToMany(
            mappedBy = "doctor", // "doctor" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<NotificationEntity> notificationEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "doctor", // "doctor" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PrescriptionEntity> prescriptionEntities = new ArrayList<>();


    public List<PrescriptionEntity> getPrescriptionEntities() {
        return prescriptionEntities;
    }

    public void setPrescriptionEntities(List<PrescriptionEntity> prescriptionEntities) {
        this.prescriptionEntities = prescriptionEntities;
    }

    public List<NotificationEntity> getNotificationEntities() {
        return notificationEntities;
    }

    public void setNotificationEntities(List<NotificationEntity> notificationEntities) {
        this.notificationEntities = notificationEntities;
    }

    public Integer getDoctorId() {
        return doctorId;
    }


    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }


    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getSpecialization() {
        return specialization;
    }


    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public Float getRating() {
        return rating;
    }


    public void setRating(Float rating) {
        this.rating = rating;
    }


    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }


    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }


    public String getBio() {
        return bio;
    }


    public void setBio(String bio) {
        this.bio = bio;
    }


    public List<UserEntity> getUserEntities() {
        return userEntities;
    }


    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }


    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}

