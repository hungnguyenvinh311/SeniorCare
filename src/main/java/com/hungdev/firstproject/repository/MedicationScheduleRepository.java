package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.MedicationScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicationScheduleRepository extends JpaRepository<MedicationScheduleEntity, Integer> {

    // Tìm các lịch uống thuốc TRƯỚC thời điểm hiện tại mà chưa được thông báo (Pending)
    @Query("SELECT s FROM MedicationScheduleEntity s WHERE s.scheduledTime <= :now AND s.status = 'Pending'")
    List<MedicationScheduleEntity> findDueSchedules(@Param("now") LocalDateTime now);
}