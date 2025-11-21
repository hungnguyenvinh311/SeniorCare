package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.MedicalProfileDTO;

public interface MedicalProfileService {
    MedicalProfileDTO getMedicalProfile(Integer useId);
    MedicalProfileDTO addAndUpdateMedicalProfile(MedicalProfileDTO dto);
}
