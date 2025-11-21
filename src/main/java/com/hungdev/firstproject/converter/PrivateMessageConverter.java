package com.hungdev.firstproject.converter;

import com.hungdev.firstproject.entity.PrivateMessageEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.PrivateMessageDTO;
import com.hungdev.firstproject.model.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrivateMessageConverter {

        @Autowired
        private ModelMapper modelMapper;

        public PrivateMessageDTO convertToDto (PrivateMessageEntity entity){
            PrivateMessageDTO result = modelMapper.map(entity, PrivateMessageDTO.class);
            return result;
        }

        public PrivateMessageEntity convertToEntity (PrivateMessageDTO dto){
            PrivateMessageEntity result = modelMapper.map(dto, PrivateMessageEntity.class);
            return result;
        }

}
