package com.sistema.gestion.candidatos.infraestructure.adapter.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigServer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
