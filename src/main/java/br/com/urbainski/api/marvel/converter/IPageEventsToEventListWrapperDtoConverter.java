package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.dto.EventListWrapperDto;

public interface IPageEventsToEventListWrapperDtoConverter extends
        IDefaultConverter<Page<Events>, EventListWrapperDto> {

}