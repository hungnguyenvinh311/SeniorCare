package com.hungdev.firstproject.converter;


import com.hungdev.firstproject.entity.ExerciseLibraryEntity;
import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.model.ExerciseLibraryDTO;
import com.hungdev.firstproject.model.NotificationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciseLibraryConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ExerciseLibraryDTO convertToDto (ExerciseLibraryEntity entity){
        ExerciseLibraryDTO result = modelMapper.map(entity, ExerciseLibraryDTO.class);
        return result;
    }

    public ExerciseLibraryEntity convertToEntity (ExerciseLibraryDTO dto){
        ExerciseLibraryEntity result = modelMapper.map(dto, ExerciseLibraryEntity.class);
        return result;
    }
}
