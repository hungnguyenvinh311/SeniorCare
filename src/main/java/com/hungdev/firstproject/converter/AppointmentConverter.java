package com.hungdev.firstproject.converter;


import com.hungdev.firstproject.entity.AppointmentEntity;
import com.hungdev.firstproject.entity.BlogEntity;
import com.hungdev.firstproject.model.AppointmentDTO;
import com.hungdev.firstproject.model.BlogDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter {
    @Autowired
    private ModelMapper modelMapper;

    public AppointmentDTO convertToDto (AppointmentEntity entity){
        AppointmentDTO result = modelMapper.map(entity, AppointmentDTO.class);
        return result;
    }

    public AppointmentEntity convertToEntity (AppointmentDTO dto){
        AppointmentEntity result = modelMapper.map(dto, AppointmentEntity.class);
        return result;
    }
}
