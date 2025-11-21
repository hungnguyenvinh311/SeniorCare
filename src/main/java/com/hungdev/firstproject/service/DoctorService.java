package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.DoctorDTO;

import java.util.List;

public interface DoctorService {
    void addDoctors(DoctorDTO doctorDTO);
    DoctorDTO findDoctorByName(String name);
    List<DoctorDTO> findDoctorBySpeciality(String speciality);
    List<DoctorDTO> findAll();
    List<DoctorDTO> findDoctorsByIds(Long[] ids);
    List<DoctorDTO> getTopRatedDoctors();
    DoctorDTO findDoctorById(Integer doctorId);
}
