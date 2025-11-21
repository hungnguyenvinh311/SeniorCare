package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByUserUserId(Integer userId);
}
