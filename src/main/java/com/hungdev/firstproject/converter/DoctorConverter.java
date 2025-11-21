package com.hungdev.firstproject.converter;

import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import com.hungdev.firstproject.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorConverter {

    @Autowired
    private ModelMapper modelMapper;

    public DoctorDTO convertToDto (DoctorEntity entity){
        DoctorDTO result = modelMapper.map(entity, DoctorDTO.class);
        return result;
    }

    public DoctorEntity convertToEntity (DoctorDTO dto){
        DoctorEntity result = modelMapper.map(dto, DoctorEntity.class);
        return result;
    }

}
