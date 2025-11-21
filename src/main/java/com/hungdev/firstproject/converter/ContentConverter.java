package com.hungdev.firstproject.converter;

import com.hungdev.firstproject.entity.ContentEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.ContentDTO;
import com.hungdev.firstproject.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ContentConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ContentDTO convertToDto (ContentEntity contentEntity){
        ContentDTO result = modelMapper.map(contentEntity, ContentDTO.class);
        return result;
    }

    public ContentEntity convertToEntity (ContentDTO dto){
        ContentEntity result = modelMapper.map(dto, ContentEntity.class);
        return result;
    }
}
