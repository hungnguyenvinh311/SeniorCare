package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.PrivateMessageConverter;
import com.hungdev.firstproject.entity.PrivateMessageEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.PrivateMessageDTO;
import com.hungdev.firstproject.repository.PrivateMessageRepository;
import com.hungdev.firstproject.repository.UserRepository;
import com.hungdev.firstproject.service.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivateMessageServiceImpl implements PrivateMessageService {
    @Autowired
    private PrivateMessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    // Giả sử bạn có một converter để chuyển đổi Entity <-> DTO
     @Autowired
     private PrivateMessageConverter converter;

    @Override
    public PrivateMessageDTO saveMessages(PrivateMessageDTO messageDTO, String senderUsername) {
        // 1. Tìm Entity người gửi (từ username đã xác thực)
        UserEntity sender = userRepository.findOneByFullName(senderUsername);
//                .orElseThrow(() -> new RuntimeException("Không tìm thấy người gửi: " + senderUsername));

        UserEntity receiver = userRepository.findById(messageDTO.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người nhận với ID: " + messageDTO.getReceiverId()));

        PrivateMessageEntity messageEntity = new PrivateMessageEntity();
        messageEntity.setSender(sender);
        messageEntity.setReceiver(receiver);
        messageEntity.setMessageBody(messageDTO.getMessageBody());
        messageEntity.setRead(false);

        PrivateMessageEntity savedEntity = messageRepository.save(messageEntity);

        return converter.convertToDto(savedEntity);
    }


}
