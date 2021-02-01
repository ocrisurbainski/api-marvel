package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IPageSeriesToSerieContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.ISeriesToSerieDtoConverter;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.dto.SerieContainerWrapperDto;
import br.com.urbainski.api.marvel.dto.SerieDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageSeriesToSerieContainerWrapperDtoConverterImpl implements
        IPageSeriesToSerieContainerWrapperDtoConverter {

    private final @NonNull ISeriesToSerieDtoConverter seriesToSerieDtoConverter;

    @Override
    public SerieContainerWrapperDto convert(Page<Series> value) {

        List<SerieDto> listSerieDto = new ArrayList<>();

        value.getContent().forEach(
                series -> listSerieDto.add(seriesToSerieDtoConverter.convert(series)));

        return SerieContainerWrapperDto.builder()
                .offset(value.getPageable().getOffset())
                .limit(value.getPageable().getPageSize())
                .count(value.getContent().size())
                .total(value.getTotalElements())
                .results(listSerieDto)
                .build();
    }

}