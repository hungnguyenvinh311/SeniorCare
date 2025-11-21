package com.hungdev.firstproject.converter;

import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConverter {

    @Autowired
    private ModelMapper modelMapper;

    public NotificationDTO convertToDto (NotificationEntity entity){
        NotificationDTO result = modelMapper.map(entity, NotificationDTO.class);
        return result;
    }

    public NotificationEntity convertToEntity (NotificationDTO dto){
        NotificationEntity result = modelMapper.map(dto, NotificationEntity.class);
        return result;
    }

}
