package com.hungdev.firstproject.service;

import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllUserNotifications(Integer userId);
    List<NotificationDTO> getAllDoctorNotifications(Integer doctorId);

    void createUserNotification(NotificationDTO notificationDTO);

    void createDoctorNotification(NotificationDTO notificationDTO);
}
