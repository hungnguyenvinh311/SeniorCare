package com.hungdev.firstproject.model;

import com.hungdev.firstproject.entity.ExerciseCategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ExerciseLibraryDTO {
    private Integer exerciseId;
    private String title;
    private String description;
    private String masterVideoUrl;
    private String difficultyLevel;
    private String focusArea;
    private Integer userExerciseSessionId;
    private Integer exerciseCategoryId;

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMasterVideoUrl() {
        return masterVideoUrl;
    }

    public void setMasterVideoUrl(String masterVideoUrl) {
        this.masterVideoUrl = masterVideoUrl;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public Integer getUserExerciseSessionId() {
        return userExerciseSessionId;
    }

    public void setUserExerciseSessionId(Integer userExerciseSessionId) {
        this.userExerciseSessionId = userExerciseSessionId;
    }

    public Integer getExerciseCategoryId() {
        return exerciseCategoryId;
    }

    public void setExerciseCategoryId(Integer exerciseCategoryId) {
        this.exerciseCategoryId = exerciseCategoryId;
    }
}
