package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.MedicalProfileDTO;
import com.hungdev.firstproject.service.MedicalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicalprofile")
@Transactional
public class MedicalProfileAPI {

    @Autowired
    private MedicalProfileService medicalProfileService;

    @GetMapping("{id}")
    public MedicalProfileDTO getUserMedicalProfile(@PathVariable(value = "id") Integer userId){
        return medicalProfileService.getMedicalProfile(userId);
    }

    @PostMapping
    public void addAndUpdateUserMedicalProfile(@RequestBody MedicalProfileDTO dto){
        medicalProfileService.addAndUpdateMedicalProfile(dto);

    }
}
