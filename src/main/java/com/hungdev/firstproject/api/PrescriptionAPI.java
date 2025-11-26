package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.PrescriptionDTO;
import com.hungdev.firstproject.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prescriptions")
@Transactional
public class PrescriptionAPI {

    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * API Kê đơn thuốc (Dành cho Bác sĩ)
     * Method: POST
     * URL: http://localhost:8080/api/prescriptions
     */
    @PostMapping
//    @PreAuthorize("hasRole('DOCTOR')") // Nên bật dòng này để bảo mật
    public ResponseEntity<?> createPrescription(@RequestBody PrescriptionDTO requestDTO) {
        try {
            // Gọi Service để xử lý logic (Lưu đơn + Sinh lịch)
            prescriptionService.createPrescription(requestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body("Kê đơn thuốc thành công và đã lên lịch nhắc nhở!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi kê đơn: " + e.getMessage());
        }
    }
}
