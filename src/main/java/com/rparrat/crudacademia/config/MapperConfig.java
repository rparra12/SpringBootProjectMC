package com.rparrat.crudacademia.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper getDefaultMapper() {
        return new ModelMapper();
    }

}
