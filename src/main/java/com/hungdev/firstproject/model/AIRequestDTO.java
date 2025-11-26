package com.hungdev.firstproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AIRequestDTO {
    private String prompt;

    public AIRequestDTO(String userPrompt) {
        this.prompt = userPrompt;
    }
    // Nếu sau này làm video, thêm field: private String videoUrl;


    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
