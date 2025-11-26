package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.entity.AIChatEntity;
import com.hungdev.firstproject.entity.AIChatMessageEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.AIChatDTO;
import com.hungdev.firstproject.model.AIRequestDTO;
import com.hungdev.firstproject.model.AIResponseDTO;
import com.hungdev.firstproject.repository.AIChatMessageRepository;
import com.hungdev.firstproject.repository.AIChatRepository;
import com.hungdev.firstproject.repository.UserRepository;
import com.hungdev.firstproject.service.AIChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AIChatServiceImpl implements AIChatService {

    // 1. Inject các dependency cần thiết
    @Autowired
    private AIChatRepository aiChatRepo;

    @Autowired
    private AIChatMessageRepository messageRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    // 2. Lấy URL từ file properties
//    @Value("${ai.service.url}")
//    private String aiApiUrl;

    private String callExternalAI(String userPrompt) {
//        try {
//            // Tạo request body
//            AIRequestDTO request = new AIRequestDTO(userPrompt);
//
//            // Gửi POST request
//            AIResponseDTO response = restTemplate.postForObject(
//                    aiApiUrl,
//                    request,
//                    AIResponseDTO.class
//            );
//
//            // Kiểm tra kết quả
//            if (response != null && response.getAnswer() != null) {
//                return response.getAnswer();
//            }
//            return "AI không phản hồi dữ liệu hợp lệ.";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Lỗi kết nối tới AI Server: " + e.getMessage();
//        }

        // Logic giả lập phản hồi dựa trên từ khóa (để test cho sinh động)
        String response;
        String promptLowerCase = userPrompt.toLowerCase();

        if (promptLowerCase.contains("chào")) {
            response = "Xin chào! Tôi là trợ lý ảo AI (đang chạy chế độ giả lập). Tôi có thể giúp gì cho bạn?";
        } else if (promptLowerCase.contains("thời tiết")) {
            response = "Tôi hiện chưa có dữ liệu thời tiết thực tế, nhưng hôm nay trời có vẻ đẹp!";
        } else if (promptLowerCase.contains("mất trí nhớ") || promptLowerCase.contains("bệnh")) {
            response = "Bệnh mất trí nhớ (Alzheimer) là một vấn đề nghiêm trọng ở người cao tuổi. Bạn cần tham khảo ý kiến bác sĩ chuyên khoa.";
        } else {
            // Phản hồi mặc định
            response = "Tôi đã nhận được câu hỏi: \"" + userPrompt + "\". Tuy nhiên, model AI thật chưa được kết nối nên đây là câu trả lời mẫu.";
        }

        return response;
    }

    @Override
    public Map<String, Object> processChat(AIChatDTO inputDto) {

        // --- GIAI ĐOẠN 1: XỬ LÝ SESSION (Bảng AIChat) ---
        AIChatEntity chatSession;

        // Nếu không có sessionId gửi lên -> Tạo cuộc hội thoại mới
        if (inputDto == null || inputDto.getSessionId() == null) {

            UserEntity userEntity = userRepository.findById(inputDto.getUserId()).get();
            chatSession = new AIChatEntity();
            chatSession.setUser(userEntity);
            chatSession.setSessionId(UUID.randomUUID().toString()); // Tạo UUID mới
            chatSession.setStartTime(LocalDateTime.now());
            chatSession.setChatTitle("Hội thoại: " + inputDto.getContent().substring(0, Math.min(inputDto.getContent().length(), 20)) + "...");
            chatSession.setMediaType(inputDto.getMediaType()); // "TEXT"

            chatSession = aiChatRepo.save(chatSession);
        } else {
            // Nếu có sessionId -> Tìm trong DB
            chatSession = aiChatRepo.findOneBySessionId(inputDto.getSessionId());
        }

        // --- GIAI ĐOẠN 2: LƯU TIN NHẮN USER (Bảng AIChatMessages) ---
        AIChatMessageEntity userMsg = new AIChatMessageEntity();
        userMsg.setAiChat(chatSession); // Link với bảng cha
        userMsg.setRole("USER");
        userMsg.setContent(inputDto.getContent());
        userMsg.setCreatedAt(LocalDateTime.now());
        messageRepo.save(userMsg);

        // --- GIAI ĐOẠN 3: GỌI AI ---
        String aiReplyText = callExternalAI(inputDto.getContent());

        // --- GIAI ĐOẠN 4: LƯU TIN NHẮN AI (Bảng AIChatMessages) ---
        AIChatMessageEntity aiMsg = new AIChatMessageEntity();
        aiMsg.setAiChat(chatSession);
        aiMsg.setRole("AI");
        aiMsg.setContent(aiReplyText);
        aiMsg.setCreatedAt(LocalDateTime.now());
        messageRepo.save(aiMsg);

        // --- GIAI ĐOẠN 5: TRẢ KẾT QUẢ VỀ CONTROLLER ---
        // Chúng ta trả về Map để linh hoạt thêm dữ liệu
        Map<String, Object> result = new HashMap<>();
        result.put("sessionId", chatSession.getSessionId()); // Quan trọng: Trả lại ID để FE dùng cho tin nhắn sau
        result.put("userMessage", inputDto.getContent());
        result.put("aiMessage", aiReplyText);

        return result;
    }




    @Override
    public void saveMessage(Integer AIChatSessionId, String role, String content) {

    }

    @Override
    public String callAI_API(String userMessage) {
        return "";
    }
}
