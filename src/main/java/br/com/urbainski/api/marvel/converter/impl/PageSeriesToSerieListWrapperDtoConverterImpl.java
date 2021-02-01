package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IPageSeriesToSerieListWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.ISeriesToSerieDtoConverter;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.dto.SerieDto;
import br.com.urbainski.api.marvel.dto.SerieListWrapperDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageSeriesToSerieListWrapperDtoConverterImpl implements IPageSeriesToSerieListWrapperDtoConverter {

    private final @NonNull ISeriesToSerieDtoConverter seriesToSerieDtoConverter;

    @Override
    public SerieListWrapperDto convert(Page<Series> value) {

        List<SerieDto> listSerieDto = new ArrayList<>();

        value.getContent().forEach(comics -> listSerieDto.add(seriesToSerieDtoConverter.convert(comics)));

        return SerieListWrapperDto.builder()
                .items(listSerieDto)
                .available(value.getTotalElements())
                .returned(value.getContent().size())
                .build();
    }

}
