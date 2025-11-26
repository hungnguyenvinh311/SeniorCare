package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.AIChatDTO;

import java.util.Map;

public interface AIChatService {
    Map<String, Object> processChat(AIChatDTO request);
    void saveMessage(Integer AIChatSessionId, String role, String content);
    String callAI_API(String userMessage);
}
