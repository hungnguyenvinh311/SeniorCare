package com.hungdev.firstproject.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Userexercisesessions")
public class UserExerciseSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "session_date")
    private Instant sessionDate;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name = "performance_score")
    private Double performanceScore;

    @Column(name = "common_mistakes", columnDefinition = "TEXT")
    private String commonMistakes;

    @Column(name = "ai_feedback", columnDefinition = "TEXT")
    private String aiFeedback;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseLibraryEntity exercise;


    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Instant getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Instant sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getCommonMistakes() {
        return commonMistakes;
    }

    public void setCommonMistakes(String commonMistakes) {
        this.commonMistakes = commonMistakes;
    }

    public String getAiFeedback() {
        return aiFeedback;
    }

    public void setAiFeedback(String aiFeedback) {
        this.aiFeedback = aiFeedback;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ExerciseLibraryEntity getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseLibraryEntity exercise) {
        this.exercise = exercise;
    }
}
