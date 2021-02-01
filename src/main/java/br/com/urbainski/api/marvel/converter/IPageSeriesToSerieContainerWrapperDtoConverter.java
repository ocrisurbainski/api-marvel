package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.dto.SerieContainerWrapperDto;

public interface IPageSeriesToSerieContainerWrapperDtoConverter extends
        IDefaultConverter<Page<Series>, SerieContainerWrapperDto> {

}