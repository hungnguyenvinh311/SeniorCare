package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.DoctorConverter;
import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.repository.DoctorRepository;
import com.hungdev.firstproject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorConverter doctorConverter;


    @Override
    public DoctorDTO findDoctorById(Integer doctorId) {
        DoctorEntity doctorEntity = doctorRepository.findById(doctorId).get();
        DoctorDTO doctorDTO = doctorConverter.convertToDto(doctorEntity);
        return doctorDTO;
    }

    @Override
    public void addDoctors(DoctorDTO doctorDTO) {
        DoctorEntity doctorEntity = doctorConverter.convertToEntity(doctorDTO);
        doctorRepository.save(doctorEntity);
    }

    @Override
    public DoctorDTO findDoctorByName(String name) {
        DoctorEntity doctorEntity = doctorRepository.findDoctorByFullName(name);
        DoctorDTO doctorDTO = doctorConverter.convertToDto(doctorEntity);
        return doctorDTO;
    }

    @Override
    public List<DoctorDTO> findDoctorBySpeciality(String speciality) {
        List<DoctorEntity> doctorEntities = doctorRepository.findDoctorBySpecialization(speciality);
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for(DoctorEntity it : doctorEntities){
            doctorDTOS.add(doctorConverter.convertToDto(it));
        }
        return doctorDTOS;
    }

    @Override
    public List<DoctorDTO> findAll() {
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        List<DoctorDTO> dtos = new ArrayList<>();
        for(DoctorEntity it : doctorEntities){
            dtos.add(doctorConverter.convertToDto(it));
        }

        return dtos;
    }

    @Override
    public List<DoctorDTO> findDoctorsByIds(Long[] ids) {
        List<DoctorEntity> doctorEntities = doctorRepository.findDoctorsByDoctorIdIn(ids);
        List<DoctorDTO> dtos = new ArrayList<>();
        for(DoctorEntity it : doctorEntities){
            dtos.add(doctorConverter.convertToDto(it));
        }

        return dtos;
    }

    @Override
    public List<DoctorDTO> getTopRatedDoctors() {
        List<DoctorEntity> doctorEntities = doctorRepository.findTop6ByOrderByRatingDesc();
        List<DoctorDTO> dtos = new ArrayList<>();
        for(DoctorEntity it : doctorEntities){
            dtos.add(doctorConverter.convertToDto(it));
        }

        return dtos;
    }
}
