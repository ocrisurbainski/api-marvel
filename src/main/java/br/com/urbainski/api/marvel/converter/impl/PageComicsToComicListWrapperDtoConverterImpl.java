package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IComicsToComicDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageComicsToComicListWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.dto.ComicDto;
import br.com.urbainski.api.marvel.dto.ComicListWrapperDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageComicsToComicListWrapperDtoConverterImpl implements IPageComicsToComicListWrapperDtoConverter {

    private final @NonNull IComicsToComicDtoConverter comicsToComicDtoConverter;

    @Override
    public ComicListWrapperDto convert(Page<Comics> value) {

        List<ComicDto> listComicDto = new ArrayList<>();

        value.getContent().forEach(comics -> listComicDto.add(comicsToComicDtoConverter.convert(comics)));

        return ComicListWrapperDto.builder()
                .items(listComicDto)
                .available(value.getTotalElements())
                .returned(value.getContent().size())
                .build();
    }

}