package com.hungdev.firstproject.service.impl;


import com.hungdev.firstproject.entity.*;
import com.hungdev.firstproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MedicationReminderScheduler {

    @Autowired
    private MedicationScheduleRepository scheduleRepo;

    @Autowired
    private NotificationRepository notificationRepo; // Repository của bảng Notifications

    @Autowired
    private UserRepository userRepository;

    // Chạy mỗi phút một lần (0 giây đầu tiên của mỗi phút)
    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void sendMedicationReminders() {
        LocalDateTime now = LocalDateTime.now();

        // 1. Tìm các lịch cần uống thuốc (Status = 'Pending' và Thời gian <= hiện tại)
        List<MedicationScheduleEntity> dueSchedules = scheduleRepo.findDueSchedules(now);

        for (MedicationScheduleEntity schedule : dueSchedules) {
            NotificationEntity notification = new NotificationEntity();

            UserEntity recipient = userRepository.findById(schedule.getUser().getUserId()).get();

            notification.setUser(recipient);
            notification.setDoctor(null);
            notification.setRecipientType("USER");

            notification.setNotificationType("MEDICATION_REMINDER"); // notification_type
            notification.setReferenceId(schedule.getScheduleId()); // reference_id (trỏ về lịch uống)

            String message = "Đã đến giờ uống thuốc: " + schedule.getPrescription().getMedicationName()
                    + ". Liều lượng: " + schedule.getPrescription().getDosage();
            notification.setMessage(message);

            notification.setRead(false); // is_read
            notification.setAlertLevel("INFO"); // alert_level
            notification.setAlertStatus("RAISED"); // alert_status

            // Lưu thông báo
            notificationRepo.save(notification);

            // 3. Cập nhật trạng thái lịch để không quét lại nữa
            schedule.setStatus("Notified"); // Đã thông báo
            scheduleRepo.save(schedule);

            System.out.println("Đã gửi nhắc nhở uống thuốc cho User: " + recipient.getFullName());


        }
    }
}