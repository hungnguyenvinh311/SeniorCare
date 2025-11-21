package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.ExerciseLibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseLibraryRepository extends JpaRepository<ExerciseLibraryEntity, Integer> {
    List<ExerciseLibraryEntity> findByDifficultyLevel(String level);
}
