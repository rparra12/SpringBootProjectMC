package com.rparrat.crudacademia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GenericResponse<T> (
        Integer status,
        String message,
        List<T> data
) {
}
