package com.rparrat.crudacademia.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    private String nameStudent;

    @NotNull
    private String lastNameStudent;

    @NotNull
    private String dniStudent;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer ageStudent;



}
