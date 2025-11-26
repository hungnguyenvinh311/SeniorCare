package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.entity.*;
import com.hungdev.firstproject.model.PrescriptionDTO;
import com.hungdev.firstproject.repository.*;
import com.hungdev.firstproject.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepo;

    @Autowired
    private MedicationScheduleRepository scheduleRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public void createPrescription(PrescriptionDTO dto) {

        UserEntity user = userRepo.findById(dto.getUserId()).orElseThrow();
        DoctorEntity doctor = doctorRepo.findById(dto.getDoctorId()).orElseThrow();
        AppointmentEntity appointment = appointmentRepo.findById(dto.getAppointmentId()).orElseThrow();

        // 2. Lưu Đơn thuốc (Prescription)
        PrescriptionEntity prescription = new PrescriptionEntity();
        prescription.setAppointment(appointment);
        prescription.setUser(user);
        prescription.setDoctor(doctor);
        prescription.setMedicationName(dto.getMedicationName());
        prescription.setDosage(dto.getDosage());
        prescription.setInstructions(dto.getInstructions());
        prescription.setStartDate(dto.getStartDate());
        prescription.setDurationDays(dto.getDurationDays());

        PrescriptionEntity savedPrescription = prescriptionRepo.save(prescription);

        // 3. Tự động sinh Lịch uống thuốc (MedicationSchedules)
        LocalDate currentDate = dto.getStartDate();
        LocalDate endDate = currentDate.plusDays(dto.getDurationDays());

        // Vòng lặp qua từng ngày
        while (currentDate.isBefore(endDate)) {
            // Vòng lặp qua từng khung giờ trong ngày (Sáng, Trưa, Tối...)
            for (LocalTime time : dto.getDailyTimes()) {
                MedicationScheduleEntity schedule = new MedicationScheduleEntity();
                schedule.setUser(user);
                schedule.setPrescription(savedPrescription);

                // Ghép Ngày + Giờ
                schedule.setScheduledTime(LocalDateTime.of(currentDate, time));
                schedule.setStatus("Pending"); // Mặc định là chờ

                scheduleRepo.save(schedule);
            }
            currentDate = currentDate.plusDays(1); // Sang ngày tiếp theo
        }
    }

}
