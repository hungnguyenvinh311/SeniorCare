package com.hungdev.firstproject.service.impl;


import com.hungdev.firstproject.converter.ExerciseLibraryConverter;
import com.hungdev.firstproject.entity.ExerciseCategoryEntity;
import com.hungdev.firstproject.entity.ExerciseLibraryEntity;
import com.hungdev.firstproject.model.ExerciseLibraryDTO;
import com.hungdev.firstproject.repository.ExerciseCategoryRepository;
import com.hungdev.firstproject.repository.ExerciseLibraryRepository;
import com.hungdev.firstproject.service.UserExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserExerciseServiceImpl implements UserExerciseService {

    @Autowired
    private ExerciseLibraryRepository exerciseLibraryRepository;

    @Autowired
    private ExerciseLibraryConverter exerciseLibraryConverter;

    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;


    @Override
    public List<ExerciseLibraryDTO> getAllExercises() {
        List<ExerciseLibraryEntity> entities = exerciseLibraryRepository.findAll();
        List<ExerciseLibraryDTO> dtos = new ArrayList<>();
        for(ExerciseLibraryEntity it : entities){
            dtos.add(exerciseLibraryConverter.convertToDto(it));
        }
        return dtos;
    }

    @Override
    public List<ExerciseLibraryDTO> getAllExercisesByExerciseCategories(String categoryName) {
        ExerciseCategoryEntity category = exerciseCategoryRepository.findOneByName(categoryName);
        List<ExerciseLibraryEntity> entities = exerciseLibraryRepository.findAll();
        List<ExerciseLibraryDTO> libraryList = new ArrayList<>();
        for(ExerciseLibraryEntity it : entities){
            if(it.getCategory().getCategoryId().equals(category.getCategoryId())){
                libraryList.add(exerciseLibraryConverter.convertToDto(it));
            }
        }
        return libraryList;
    }

    @Override
    public List<ExerciseLibraryDTO> getAllExercisesByDifficultyLevel(String level) {
        List<ExerciseLibraryEntity> entities = exerciseLibraryRepository.findByDifficultyLevel(level);
        List<ExerciseLibraryDTO> dtos = new ArrayList<>();
        for(ExerciseLibraryEntity it : entities){
            dtos.add(exerciseLibraryConverter.convertToDto(it));
        }
        return dtos;
    }


    @Override
    public ExerciseLibraryDTO UpdateExercises(ExerciseLibraryDTO exerciseLibraryDTO) {
        if (exerciseLibraryDTO.getExerciseId() != null) {
            ExerciseLibraryEntity libraryEntity = exerciseLibraryRepository.findById(exerciseLibraryDTO.getExerciseId()).get();
            libraryEntity.setTitle(exerciseLibraryDTO.getTitle());
            libraryEntity.setDescription(exerciseLibraryDTO.getDescription());
            libraryEntity.setMasterVideoUrl(exerciseLibraryDTO.getMasterVideoUrl());
            libraryEntity.setDifficultyLevel(exerciseLibraryDTO.getDifficultyLevel());
            libraryEntity.setFocusArea(exerciseLibraryDTO.getDifficultyLevel());

            if(exerciseLibraryDTO.getExerciseCategoryId() != null) {
                ExerciseCategoryEntity category = exerciseCategoryRepository.findById(exerciseLibraryDTO.getExerciseId()).get();
                libraryEntity.setCategory(category);
            }
            exerciseLibraryRepository.save(libraryEntity);

            return exerciseLibraryConverter.convertToDto(libraryEntity);
        }
        return null;
    }

    @Override
    public void addExercises(ExerciseLibraryDTO exerciseLibraryDTO) {
        ExerciseLibraryEntity libraryEntity = exerciseLibraryConverter.convertToEntity(exerciseLibraryDTO);
        exerciseLibraryRepository.save(libraryEntity);
    }
}
