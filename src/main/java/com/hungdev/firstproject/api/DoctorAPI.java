package com.hungdev.firstproject.api;


import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import com.hungdev.firstproject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@Transactional
public class DoctorAPI {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public void addNewDoctors(@RequestBody DoctorDTO doctorDTO){
        doctorService.addDoctors(doctorDTO);
        System.out.println("Đã thêm bác sĩ mói thành công");
    }

    @GetMapping("/specialty")
    public List<DoctorDTO> findDoctorsBySpeciality(@RequestParam(value = "speciality", required = true) String speciality){
        List<DoctorDTO> doctorDTOS = doctorService.findDoctorBySpeciality(speciality);
        return doctorDTOS;
    }

    @GetMapping("/doctorname")
    public DoctorDTO findDoctorByName(@RequestParam(value = "name") String name){
        DoctorDTO doctorDTO = doctorService.findDoctorByName(name);
        return doctorDTO;
    }

    @GetMapping
    public List<DoctorDTO> findAllDoctors(){
        List<DoctorDTO> dtos = doctorService.findAll();
        return dtos;
    }

    @GetMapping("/{ids}")
    public List<DoctorDTO> findDoctorsByIDs(@PathVariable(value = "ids") Long[] ids){
        List<DoctorDTO> dtos = doctorService.findDoctorsByIds(ids);
        return dtos;
    }

    @GetMapping("/top-rated")
    public List<DoctorDTO> findTopRatedDoctors(){
        List<DoctorDTO> dtos = doctorService.getTopRatedDoctors();
        return dtos;
    }
}
