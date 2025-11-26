package com.hungdev.firstproject.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Aichat")
public class AIChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(name = "chat_title")
    private String chatTitle;

    // Các trường khác (description, emotion, summary...)

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "chat_summary")
    private String chatSummary;

    @Column(name = "detected_emotion")
    private String detectedEmotion;

    @Column(name = "storage_url")
    private String storageUrl;


    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "aiChat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AIChatMessageEntity> messages;

    public Integer getId() {
        return logId;
    }

    public void setId(Integer logId) {
        this.logId = logId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getChatSummary() {
        return chatSummary;
    }

    public void setChatSummary(String chatSummary) {
        this.chatSummary = chatSummary;
    }

    public String getDetectedEmotion() {
        return detectedEmotion;
    }

    public void setDetectedEmotion(String detectedEmotion) {
        this.detectedEmotion = detectedEmotion;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<AIChatMessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<AIChatMessageEntity> messages) {
        this.messages = messages;
    }
}
