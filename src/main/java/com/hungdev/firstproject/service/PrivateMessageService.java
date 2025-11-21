package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.PrivateMessageDTO;

public interface PrivateMessageService {
    PrivateMessageDTO saveMessages(PrivateMessageDTO messageDTO, String senderUsername);
}
