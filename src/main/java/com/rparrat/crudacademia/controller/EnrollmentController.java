package com.rparrat.crudacademia.controller;

import com.rparrat.crudacademia.dto.EnrollmentDTO;
import com.rparrat.crudacademia.dto.GenericResponse;
import com.rparrat.crudacademia.model.Enrollment;
import com.rparrat.crudacademia.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<EnrollmentDTO>> findAllEnrollments() throws Exception {
        List<EnrollmentDTO> enrollments = service.findAll().stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(new GenericResponse<>(200, "success", enrollments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollmentDTO>> findById(@Valid  @PathVariable Integer id) throws Exception {
        Enrollment enrollment = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(this.convertToDTO(enrollment))));
    }

    @GetMapping("/enrollmentCourseAndStudent")
    public ResponseEntity<GenericResponse<Map<String, List<String>>>> getEnrollmentsCourseAndStudents() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(service.getEnrollmentsCourseAndStudents())));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<EnrollmentDTO>> saveEnrollment(@Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        Enrollment enrollment = service.save(this.convertToEntity(enrollmentDTO));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(this.convertToDTO(enrollment))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollmentDTO>> updateEnrollment(@Valid @PathVariable Integer id, @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        Enrollment enrollment = service.update(id, this.convertToEntity(enrollmentDTO));;
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(this.convertToDTO(enrollment))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@Valid @PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    public EnrollmentDTO convertToDTO(Enrollment enrollment) {
        return modelMapper.map(enrollment, EnrollmentDTO.class);
    }

    public Enrollment convertToEntity(EnrollmentDTO enrollmentDTO) {
        return modelMapper.map(enrollmentDTO, Enrollment.class);
    }

}
