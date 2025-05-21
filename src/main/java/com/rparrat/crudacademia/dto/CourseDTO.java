package com.rparrat.crudacademia.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    private String nameCourse;

    @NotNull
    private String acronymCourse;

    @NotNull
    private boolean statusCourse;

}
