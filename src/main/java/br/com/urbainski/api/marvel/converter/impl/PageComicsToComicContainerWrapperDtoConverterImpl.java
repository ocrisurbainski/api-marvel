package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IComicsToComicDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageComicsToComicContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.dto.ComicContainerWrapperDto;
import br.com.urbainski.api.marvel.dto.ComicDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageComicsToComicContainerWrapperDtoConverterImpl implements
        IPageComicsToComicContainerWrapperDtoConverter {

    private final @NonNull IComicsToComicDtoConverter comicsToComicDtoConverter;

    @Override
    public ComicContainerWrapperDto convert(Page<Comics> value) {

        List<ComicDto> listComicDto = new ArrayList<>();

        value.getContent().forEach(
                comics -> listComicDto.add(comicsToComicDtoConverter.convert(comics)));

        return ComicContainerWrapperDto.builder()
                .offset(value.getPageable().getOffset())
                .limit(value.getPageable().getPageSize())
                .count(value.getContent().size())
                .total(value.getTotalElements())
                .results(listComicDto)
                .build();
    }

}