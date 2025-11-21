package com.hungdev.firstproject.service;

import com.hungdev.firstproject.entity.ExerciseLibraryEntity;
import com.hungdev.firstproject.model.ExerciseLibraryDTO;

import java.util.List;

public interface UserExerciseService {
    List<ExerciseLibraryDTO> getAllExercises();
    List<ExerciseLibraryDTO> getAllExercisesByExerciseCategories(String categoryName);
    List<ExerciseLibraryDTO> getAllExercisesByDifficultyLevel(String level);

    ExerciseLibraryDTO UpdateExercises(ExerciseLibraryDTO exerciseLibraryDTO);

    void addExercises(ExerciseLibraryDTO exerciseLibraryDTO);


}
