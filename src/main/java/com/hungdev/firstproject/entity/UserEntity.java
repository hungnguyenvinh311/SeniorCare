package com.hungdev.firstproject.entity;


import com.hungdev.firstproject.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@Entity
@Table(name = "Users")


public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;


    @Column(name = "date_of_birth")
    private Date dateOfBirth;


    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;


    @Column(name = "password_hash", nullable = false)
    private String passwordHash;


    @Column(name = "hometown")
    private String hometown;


    @Column(name = "current_address")
    private String currentAddress;


    @Column(name = "profile_picture_url")
    private String profilePictureUrl;


    @Column(name = "hobbies")
    private String hobbies;


    @Column(name = "personal_story")
    private String personalStory;


    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;


    @Column(name = "emergency_contact_email")
    private String emergencyContactEmail;




    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();




    @ManyToMany(mappedBy = "userEntities", fetch = FetchType.LAZY)
    private List<DoctorEntity> doctorEntities = new ArrayList<>();




    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<AppointmentEntity> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<NotificationEntity> notifications = new ArrayList<>();


    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<MedicalProfileEntity> profileEntities = new ArrayList<>();


    @OneToMany(mappedBy = "sender", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<PrivateMessageEntity> senderMessageEntities = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<PrivateMessageEntity> receiverMessageEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<UserExerciseSessionEntity> userExerciseSessionEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<MedicationScheduleEntity> medicationScheduleEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<PrescriptionEntity> prescriptionEntities = new ArrayList<>();


    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<AIChatEntity> aiChatEntities = new ArrayList<>();

    public List<AIChatEntity> getAiChatEntities() {
        return aiChatEntities;
    }

    public void setAiChatEntities(List<AIChatEntity> aiChatEntities) {
        this.aiChatEntities = aiChatEntities;
    }

    public List<PrescriptionEntity> getPrescriptionEntities() {
        return prescriptionEntities;
    }

    public void setPrescriptionEntities(List<PrescriptionEntity> prescriptionEntities) {
        this.prescriptionEntities = prescriptionEntities;
    }

    public List<MedicationScheduleEntity> getMedicationScheduleEntities() {
        return medicationScheduleEntities;
    }

    public void setMedicationScheduleEntities(List<MedicationScheduleEntity> medicationScheduleEntities) {
        this.medicationScheduleEntities = medicationScheduleEntities;
    }

    public List<UserExerciseSessionEntity> getUserExerciseSessionEntities() {
        return userExerciseSessionEntities;
    }

    public void setUserExerciseSessionEntities(List<UserExerciseSessionEntity> userExerciseSessionEntities) {
        this.userExerciseSessionEntities = userExerciseSessionEntities;
    }

    public List<PrivateMessageEntity> getSenderMessageEntities() {
        return senderMessageEntities;
    }

    public void setSenderMessageEntities(List<PrivateMessageEntity> senderMessageEntities) {
        this.senderMessageEntities = senderMessageEntities;
    }

    public List<PrivateMessageEntity> getReceiverMessageEntities() {
        return receiverMessageEntities;
    }

    public void setReceiverMessageEntities(List<PrivateMessageEntity> receiverMessageEntities) {
        this.receiverMessageEntities = receiverMessageEntities;
    }

    public List<MedicalProfileEntity> getProfileEntities() {
        return profileEntities;
    }

    public void setProfileEntities(List<MedicalProfileEntity> profileEntities) {
        this.profileEntities = profileEntities;
    }

    public List<NotificationEntity> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }


    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }


    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }


    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }


    public String getHobbies() {
        return hobbies;
    }


    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }


    public String getPersonalStory() {
        return personalStory;
    }


    public void setPersonalStory(String personalStory) {
        this.personalStory = personalStory;
    }


    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }


    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }


    public String getEmergencyContactEmail() {
        return emergencyContactEmail;
    }


    public void setEmergencyContactEmail(String emergencyContactEmail) {
        this.emergencyContactEmail = emergencyContactEmail;
    }


    public List<RoleEntity> getRoles() {
        return roles;
    }


    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }


    public List<DoctorEntity> getDoctorEntities() {
        return doctorEntities;
    }


    public void setDoctorEntities(List<DoctorEntity> doctorEntities) {
        this.doctorEntities = doctorEntities;
    }


    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}

