package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.AIChatDTO;
import com.hungdev.firstproject.service.AIChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ai-chat")
@Transactional
public class AIChatAPI {

    @Autowired
    private AIChatService aiService;

    @PostMapping("/send")
    public ResponseEntity<?> chat(@RequestBody AIChatDTO input) {
        try {
            Map<String, Object> response = aiService.processChat(input);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi: " + e.getMessage());
        }
    }
}
