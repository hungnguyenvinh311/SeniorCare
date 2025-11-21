package com.hungdev.firstproject.converter;

import com.hungdev.firstproject.entity.MedicalProfileEntity;
import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.model.MedicalProfileDTO;
import com.hungdev.firstproject.model.NotificationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalProfileConverter {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalProfileDTO convertToDto (MedicalProfileEntity entity){
        MedicalProfileDTO result = modelMapper.map(entity, MedicalProfileDTO.class);
        return result;
    }

    public MedicalProfileEntity convertToEntity (MedicalProfileDTO dto){
        MedicalProfileEntity result = modelMapper.map(dto, MedicalProfileEntity.class);
        return result;
    }
}
