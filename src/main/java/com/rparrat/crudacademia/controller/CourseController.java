package com.rparrat.crudacademia.controller;

import com.rparrat.crudacademia.dto.CourseDTO;
import com.rparrat.crudacademia.dto.GenericResponse;
import com.rparrat.crudacademia.model.Course;
import com.rparrat.crudacademia.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<CourseDTO>> findAll() throws Exception {
        List<CourseDTO> courses = service.findAll().stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(new GenericResponse<>(200, "success", courses));
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> findById(@Valid  @PathVariable Integer id) throws Exception {
        Course course = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(this.convertToDTO(course))));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CourseDTO>> saveCourse(@Valid @RequestBody CourseDTO courseDTO) throws Exception {
        Course course = service.save(this.convertToEntity(courseDTO));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(this.convertToDTO(course))), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> updateCourse(@Valid @PathVariable Integer id, @RequestBody CourseDTO courseDTO) throws Exception {
        Course course = service.update(id, this.convertToEntity(courseDTO));
        return ResponseEntity.ok(new GenericResponse<>(200, "success", List.of(this.convertToDTO(course))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@Valid @PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    public CourseDTO convertToDTO(Course course){
        return modelMapper.map(course, CourseDTO.class);
    }

    public Course convertToEntity(CourseDTO courseDTO){
        return modelMapper.map(courseDTO, Course.class);
    }

}
