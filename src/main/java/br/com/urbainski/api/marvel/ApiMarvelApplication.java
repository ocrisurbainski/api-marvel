package br.com.urbainski.api.marvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;

import br.com.urbainski.api.marvel.serializer.LocalDateTimeSerializer;

@SpringBootApplication
public class ApiMarvelApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiMarvelApplication.class, args);
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializers(new LocalDateTimeSerializer())
                .visibility(PropertyAccessor.FIELD, Visibility.ANY);
    }

}