package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Transactional
public class NotificationAPI {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/users")
    public List<NotificationDTO> getAllUserNotifications(@RequestParam Integer userId){
        List<NotificationDTO> dtos = notificationService.getAllUserNotifications(userId);
        return dtos;
    }

    @GetMapping("/doctors")
    public List<NotificationDTO> getAllDoctorNotifications(@RequestParam Integer doctorId){
        List<NotificationDTO> dtos = notificationService.getAllDoctorNotifications(doctorId);
        return dtos;
    }

    @PostMapping("/user")
    public void newUserNotifications(@RequestBody NotificationDTO notificationDTO){
        notificationService.createUserNotification(notificationDTO);
    }


    @PostMapping("/doctor")
    public void newDoctorNotifications(@RequestBody NotificationDTO notificationDTO){
        notificationService.createDoctorNotification(notificationDTO);
    }
}
