package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.dto.ComicContainerWrapperDto;

public interface IPageComicsToComicContainerWrapperDtoConverter extends
        IDefaultConverter<Page<Comics>, ComicContainerWrapperDto> {

}