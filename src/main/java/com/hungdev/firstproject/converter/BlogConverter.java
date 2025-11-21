package com.hungdev.firstproject.converter;


import com.hungdev.firstproject.entity.BlogEntity;
import com.hungdev.firstproject.entity.ContentEntity;
import com.hungdev.firstproject.model.BlogDTO;
import com.hungdev.firstproject.model.ContentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BlogDTO convertToDto (BlogEntity entity){
        BlogDTO result = modelMapper.map(entity, BlogDTO.class);
        return result;
    }

    public BlogEntity convertToEntity (BlogDTO dto){
        BlogEntity result = modelMapper.map(dto, BlogEntity.class);
        return result;
    }
}
