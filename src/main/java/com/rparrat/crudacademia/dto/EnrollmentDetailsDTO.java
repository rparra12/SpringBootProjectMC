package com.rparrat.crudacademia.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailsDTO {

    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull
    @JsonIncludeProperties(value = {"idCourse"})
    private CourseDTO course;

    @NotNull
    private String classroomEnrollment;

}
