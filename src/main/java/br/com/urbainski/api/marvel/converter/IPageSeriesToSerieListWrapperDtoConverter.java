package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.dto.SerieListWrapperDto;

public interface IPageSeriesToSerieListWrapperDtoConverter extends
        IDefaultConverter<Page<Series>, SerieListWrapperDto> {

}