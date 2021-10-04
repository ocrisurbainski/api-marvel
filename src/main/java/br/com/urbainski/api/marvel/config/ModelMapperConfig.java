package br.com.urbainski.api.marvel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cristian Urbainski
 * @since 04/10/2021
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {

        var modelMapper = new ModelMapper();
        return modelMapper;
    }

}
