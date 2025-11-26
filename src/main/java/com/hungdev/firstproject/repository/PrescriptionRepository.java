package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Integer> {
}
