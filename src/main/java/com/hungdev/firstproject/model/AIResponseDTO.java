package com.hungdev.firstproject.model;


import lombok.Data;

@Data
public class AIResponseDTO {
    private String status;
    private String answer; // Tên trường này phải KHỚP với JSON bên Python trả về

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
