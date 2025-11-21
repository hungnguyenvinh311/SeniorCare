package com.hungdev.firstproject.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Exerciselibrary")
public class ExerciseLibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer exerciseId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "master_video_url")
    private String masterVideoUrl;

    @Column(name = "difficulty_level")
    private String difficultyLevel;

    @Column(name = "focus_area")
    private String focusArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ExerciseCategoryEntity category;


    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserExerciseSessionEntity> userSessions;


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

    public ExerciseCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ExerciseCategoryEntity category) {
        this.category = category;
    }

    public List<UserExerciseSessionEntity> getUserSessions() {
        return userSessions;
    }

    public void setUserSessions(List<UserExerciseSessionEntity> userSessions) {
        this.userSessions = userSessions;
    }
}
