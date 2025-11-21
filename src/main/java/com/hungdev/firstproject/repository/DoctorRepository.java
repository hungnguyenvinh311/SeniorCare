package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    DoctorEntity findDoctorByFullName(String fullname);
    List<DoctorEntity> findDoctorBySpecialization(String specialization);
    List<DoctorEntity> findDoctorsByDoctorIdIn(Long[] ids);
    List<DoctorEntity> findTop6ByOrderByRatingDesc();
}
