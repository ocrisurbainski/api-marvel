package br.com.urbainski.api.marvel.converter.impl;

import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.ISeriesToSerieDtoConverter;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.dto.SerieDto;

@Component
public class SeriesToSerieDtoConverterImpl implements ISeriesToSerieDtoConverter {

    @Override
    public SerieDto convert(Series value) {

        return new SerieDto(value.getId(), value.getName());
    }

}