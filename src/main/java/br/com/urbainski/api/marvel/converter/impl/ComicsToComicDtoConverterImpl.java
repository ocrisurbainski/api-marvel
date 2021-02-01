package br.com.urbainski.api.marvel.converter.impl;

import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IComicsToComicDtoConverter;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.dto.ComicDto;

@Component
public class ComicsToComicDtoConverterImpl implements IComicsToComicDtoConverter {

    @Override
    public ComicDto convert(Comics value) {

        return new ComicDto(value.getId(), value.getName());
    }

}