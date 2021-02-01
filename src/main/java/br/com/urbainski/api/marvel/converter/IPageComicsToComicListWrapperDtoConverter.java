package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.dto.ComicListWrapperDto;

public interface IPageComicsToComicListWrapperDtoConverter extends
        IDefaultConverter<Page<Comics>, ComicListWrapperDto> {

}