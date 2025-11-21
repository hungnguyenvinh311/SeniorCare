package com.hungdev.firstproject.model;

import com.hungdev.firstproject.entity.UserEntity;
import jakarta.persistence.*;

public class MedicalProfileDTO {
    private Integer profileId;
    private Integer userId;
    private String primaryCondition;
    private String medicalHistory;
    private String allergies;

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPrimaryCondition() {
        return primaryCondition;
    }

    public void setPrimaryCondition(String primaryCondition) {
        this.primaryCondition = primaryCondition;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
