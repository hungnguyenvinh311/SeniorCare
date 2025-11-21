package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.MedicalProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalProfileRepository extends JpaRepository<MedicalProfileEntity, Long> {
    MedicalProfileEntity findByUserUserId(Integer userId);
}
