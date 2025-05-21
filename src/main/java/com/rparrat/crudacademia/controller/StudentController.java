package com.rparrat.crudacademia.controller;

import com.rparrat.crudacademia.dto.GenericResponse;
import com.rparrat.crudacademia.dto.StudentDTO;
import com.rparrat.crudacademia.model.Student;
import com.rparrat.crudacademia.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>> getAllStudents() throws Exception {
        List<StudentDTO> listEstudentDTO = service.findAll().stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(new GenericResponse<>(200, "success", listEstudentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> getStudentById(@Valid @PathVariable Integer id) throws Exception {
        Student student = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(convertToDTO(student))));
    }

    @GetMapping("/orderAges")
    public ResponseEntity<GenericResponse<StudentDTO>> getStudentsOrderAge() throws Exception{
        List<StudentDTO> listEstudentDTO = service.findAllStudentsOrderAge().stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(new GenericResponse<>(200, "success", listEstudentDTO));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<StudentDTO>> saveStudent(@Valid @RequestBody StudentDTO studentDTO) throws Exception {
        Student student = service.save(this.convertToEntity(studentDTO));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(convertToDTO(student))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> updateStudent(@PathVariable Integer id,@Valid @RequestBody StudentDTO StudentDTO) throws Exception {
        Student student = service.update(id, this.convertToEntity(StudentDTO));
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(this.convertToDTO(student))));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<GenericResponse<Void>> deleteStudent(@Valid @PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private StudentDTO convertToDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

}
