package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.ExerciseCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategoryEntity, Integer> {
    ExerciseCategoryEntity findOneByName(String name);

}
