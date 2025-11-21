package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.AppointmentConverter;
import com.hungdev.firstproject.entity.AppointmentEntity;
import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.enums.AppointmentStatus;
import com.hungdev.firstproject.model.AppointmentDTO;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.repository.AppointmentRepository;
import com.hungdev.firstproject.repository.DoctorRepository;
import com.hungdev.firstproject.repository.UserRepository;
import com.hungdev.firstproject.service.AppointmentService;
import com.hungdev.firstproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AppointmentConverter appointmentConverter;



    @Override
    public void creatAppointment(AppointmentDTO dto) {
        // 1. Tìm các Entity liên quan
        UserEntity patient = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Bệnh nhân (User) ID: " + dto.getUserId()));

        DoctorEntity doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Bác sĩ (Doctor) ID: " + dto.getDoctorId()));

        // (Logic kiểm tra tính khả dụng:
        //  Bạn nên thêm logic kiểm tra xem bác sĩ có rảnh vào giờ này không)

        // 2. Tạo đối tượng Appointment mới
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setUser(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setUserSymptoms(dto.getUserSymptoms());
        appointment.setStatus(String.valueOf(AppointmentStatus.PENDING)); // Trạng thái chờ

        // 3. Lưu lịch hẹn vào DB
        AppointmentEntity savedAppointment = appointmentRepository.save(appointment);

        // 4. *** TẠO THÔNG BÁO CHO BÁC SĨ ***
        String message = "Bạn có lịch hẹn mới từ bệnh nhân "
                + patient.getFullName()
                + " với mã lịch hẹn là " + savedAppointment.getAppointmentId()
                + " vào lúc " + dto.getAppointmentTime().toLocalTime();

        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setDoctorId(doctor.getDoctorId());
        notificationDTO.setUserId(patient.getUserId());
        notificationDTO.setMessage(message);
        notificationDTO.setRead(false);


        String messageForPatient = "Bạn đã đặt lịch với bác sĩ " + doctor.getFullName()

                + " vào khoảng thời gian " + appointment.getAppointmentTime()
                + " với mã của buổi hẹn là " + savedAppointment.getAppointmentId();
        NotificationDTO notificationForPatient = new NotificationDTO();

        notificationForPatient.setUserId(patient.getUserId());
        notificationForPatient.setMessage(message);
        notificationForPatient.setRead(false);

        notificationService.createDoctorNotification(notificationDTO);
    }

    @Override
    public void cancelAppointment(Integer appointmentID) {
        AppointmentEntity appointment = appointmentRepository.findById(appointmentID).get();
        appointment.setStatus(String.valueOf(AppointmentStatus.CANCELLED));

        UserEntity patient = appointment.getUser();
        DoctorEntity doctor = appointment.getDoctor();

        String message = "Cuộc hẹn có mã là " + appointment.getAppointmentId()
                +  " với bệnh nhân " + patient.getFullName()
                + " vào khoảng thời gian " + appointment.getAppointmentTime()
                + " đã bị hủy";
        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setDoctorId(doctor.getDoctorId());
        notificationDTO.setMessage(message);
        notificationDTO.setRead(false);

        String messageForPatient = "Cuộc hẹn có mã là " + appointment.getAppointmentId()
                +  " với bác sĩ " + doctor.getFullName()
                + " vào khoảng thời gian " + appointment.getAppointmentTime()
                + " đã bị hủy";
        NotificationDTO notificationForPatient = new NotificationDTO();

        notificationForPatient.setUserId(patient.getUserId());
        notificationForPatient.setMessage(message);
        notificationForPatient.setRead(false);

        notificationService.createDoctorNotification(notificationDTO);
        notificationService.createUserNotification(notificationForPatient);
        appointmentRepository.save(appointment);


    }


    @Override
    public List<AppointmentDTO> getUserAppointments(Integer userId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findByUserUserId(userId);
        List<AppointmentDTO> dtos = new ArrayList<>();
        for(AppointmentEntity it : appointmentEntities){
            dtos.add(appointmentConverter.convertToDto(it));
        }

        return dtos;
    }


    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO dto) {
        AppointmentEntity appointment = appointmentRepository.findById(dto.getAppointmentId()).get();

        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setStatus(dto.getStatus());
        appointment.setDoctorNotes(dto.getDoctorNotes());


        return appointmentConverter.convertToDto(appointmentRepository.save(appointment));
    }
}
