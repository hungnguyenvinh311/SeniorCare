package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.MedicalProfileConverter;
import com.hungdev.firstproject.entity.MedicalProfileEntity;
import com.hungdev.firstproject.model.MedicalProfileDTO;
import com.hungdev.firstproject.repository.MedicalProfileRepository;
import com.hungdev.firstproject.service.MedicalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicalProfileImpl implements MedicalProfileService {

    @Autowired
    private MedicalProfileRepository medicalProfileRepository;

    @Autowired
    private MedicalProfileConverter medicalProfileConverter;
    @Override
    public MedicalProfileDTO getMedicalProfile(Integer useId) {
        MedicalProfileEntity medicalProfile = medicalProfileRepository.findByUserUserId(useId);
        MedicalProfileDTO medicalProfileDTO = medicalProfileConverter.convertToDto(medicalProfile);
        return medicalProfileDTO;
    }

    @Override
    public MedicalProfileDTO addAndUpdateMedicalProfile(MedicalProfileDTO dto) {
        MedicalProfileEntity newProfile = medicalProfileConverter.convertToEntity(dto);
        medicalProfileRepository.save(newProfile);
        return null;
    }
}
