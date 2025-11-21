package com.hungdev.firstproject.api;

import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.service.IUserService;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungdev.firstproject.model.PrivateMessageDTO;
import com.hungdev.firstproject.service.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;

@ServerEndpoint("/ws/{userId}")
@Component
public class PrivateMessageAPI {

    private static Map<String, Session> userSessions = new ConcurrentHashMap<>();
    private static PrivateMessageService messageServiceStatic;
    private static IUserService userServiceStatic;

    // Dùng setter tĩnh để Spring inject Service vào @ServerEndpoint
    @Autowired
    public void setServices(PrivateMessageService messageService, IUserService userService) {
        PrivateMessageAPI.messageServiceStatic = messageService;
        PrivateMessageAPI.userServiceStatic = userService;
    }

    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        PrivateMessageAPI.objectMapper = objectMapper;
    }


    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        System.out.println("🔗 User connected: " + userId + ", sessionId: " + session.getId());
        userSessions.put(userId, session);
    }

    @OnMessage
    public void onMessage(@PathParam("userId") Integer senderId, String message, Session session) {
        try {
            // Parse JSON message từ client
            PrivateMessageDTO dto = objectMapper.readValue(message, PrivateMessageDTO.class);

            // Gọi service layer để lưu message

            UserDTO sender = userServiceStatic.findUserById(senderId);
            dto.setSenderId(senderId);
            PrivateMessageDTO savedDto = messageServiceStatic.saveMessages(dto, sender.getFullName()); // service lưu vào DB

            Integer receiverId = savedDto.getReceiverId();
            Session receiverSession = userSessions.get(receiverId);

            // Gửi real-time đến receiver nếu đang online
            if (receiverSession != null && receiverSession.isOpen()) {
                receiverSession.getBasicRemote()
                        .sendText(objectMapper.writeValueAsString(savedDto));
            }

            // (Tuỳ chọn) Gửi lại cho chính sender để đồng bộ "đã gửi"
            session.getBasicRemote()
                    .sendText(objectMapper.writeValueAsString(savedDto));

            System.out.println("✅ Message sent from " + senderId + " to " + receiverId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(@PathParam("userId") String userId, Session session) {
        System.out.println("❌ User disconnected: " + userId);
        userSessions.remove(userId);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
