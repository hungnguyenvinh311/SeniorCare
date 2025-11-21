package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.DoctorConverter;
import com.hungdev.firstproject.converter.NotificationConverter;
import com.hungdev.firstproject.converter.UserConverter;
import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.repository.NotificationRepository;
import com.hungdev.firstproject.service.DoctorService;
import com.hungdev.firstproject.service.IUserService;
import com.hungdev.firstproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationConverter notificationConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorConverter doctorConverter;

    @Override
    public List<NotificationDTO> getAllUserNotifications(Integer userId) {
        UserDTO userDTO = iUserService.findUserById(userId);
        UserEntity user = userConverter.convertToEntity(userDTO);
        List<NotificationEntity> notificationEntities = notificationRepository.findByUserAndIsReadFalseOrderByCreatedAtDesc(user);
        List<NotificationDTO> dtos = new ArrayList<>();
        for(NotificationEntity it : notificationEntities){
            dtos.add(notificationConverter.convertToDto(it));
            it.setRead(true);
            notificationRepository.save(it);
        }
        return dtos;
    }


    @Override
    public List<NotificationDTO> getAllDoctorNotifications(Integer doctorId) {
        DoctorDTO doctorDTO = doctorService.findDoctorById(doctorId);
        DoctorEntity doctor = doctorConverter.convertToEntity(doctorDTO);
        List<NotificationEntity> notificationEntities = notificationRepository.findByDoctorAndIsReadFalseOrderByCreatedAtDesc(doctor);
        List<NotificationDTO> dtos = new ArrayList<>();
        for(NotificationEntity it : notificationEntities){
            dtos.add(notificationConverter.convertToDto(it));
            it.setRead(true);
            notificationRepository.save(it);
        }
        return dtos;
    }

    @Override
    public void createUserNotification(NotificationDTO notificationDTO) {
        if(notificationDTO.getUserId() != null) {
            UserDTO recipientUser = iUserService.findUserById(notificationDTO.getUserId());
            NotificationEntity notification = new NotificationEntity();

            notification.setUser(userConverter.convertToEntity(recipientUser));
            notification.setAlertLevel(notificationDTO.getAlertLevel());
            notification.setAlertStatus(notificationDTO.getAlertStatus());
            notification.setRecipientType(notificationDTO.getRecipientType());
            notification.setMessage(notificationDTO.getMessage());
            notification.setNotificationType(notificationDTO.getNotificationType());
            notification.setReferenceId(notificationDTO.getReferenceId());
            notification.setRead(false);
            notificationRepository.save(notification);
        }
    }


    @Override
    public void createDoctorNotification(NotificationDTO notificationDTO) {
        if(notificationDTO.getDoctorId() != null) {
            DoctorDTO recipientDoctor = doctorService.findDoctorById(notificationDTO.getDoctorId());
            NotificationEntity notification = new NotificationEntity();

            notification.setDoctor(doctorConverter.convertToEntity(recipientDoctor));
            notification.setRecipientType(notificationDTO.getRecipientType());
            notification.setMessage(notificationDTO.getMessage());
            notification.setNotificationType(notificationDTO.getNotificationType());
            notification.setReferenceId(notificationDTO.getReferenceId());
            notification.setRead(false);
            notificationRepository.save(notification);
        }
    }
}


