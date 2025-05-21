package com.rparrat.crudacademia.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private LocalDate enrollmentDate;

    @NotNull
    @JsonIncludeProperties(value = {"idStudent"})
    private StudentDTO student;

    @NotNull
    private boolean statusEnrollment;

    @NotNull
    @JsonManagedReference
    List<EnrollmentDetailsDTO> details;

}
