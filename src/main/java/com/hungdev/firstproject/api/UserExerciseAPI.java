package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.ExerciseLibraryDTO;
import com.hungdev.firstproject.service.UserExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/userexercises")
public class UserExerciseAPI {

    @Autowired
    private UserExerciseService userExerciseService;

    @GetMapping
    public List<ExerciseLibraryDTO> getAllExercises(){
        List<ExerciseLibraryDTO> dtoList = userExerciseService.getAllExercises();
        return dtoList;
    }

    @GetMapping("/categories")
    public List<ExerciseLibraryDTO> getAllExercisesByExerciseCategories(@RequestParam String categoryName){
        List<ExerciseLibraryDTO> dtoList = userExerciseService.getAllExercisesByExerciseCategories(categoryName);
        return dtoList;
    }

    @GetMapping("/difficulty")
    public List<ExerciseLibraryDTO> getAllExercisesByDifficultyLevel(@RequestParam String level) {
        List<ExerciseLibraryDTO> dtoList = userExerciseService.getAllExercisesByDifficultyLevel(level);
        return dtoList;
    }

    @PostMapping
    public void addNewExercises(@RequestBody ExerciseLibraryDTO exerciseLibraryDTO){
        userExerciseService.addExercises(exerciseLibraryDTO);
    }

    @PutMapping
    public ExerciseLibraryDTO updateExercises(@RequestBody ExerciseLibraryDTO exerciseLibraryDTO){
        ExerciseLibraryDTO newExercise = userExerciseService.UpdateExercises(exerciseLibraryDTO);
        return newExercise;
    }



}
