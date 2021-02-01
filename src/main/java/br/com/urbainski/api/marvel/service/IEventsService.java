package br.com.urbainski.api.marvel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Events;

public interface IEventsService extends IDefaultService<Events, Long> {

    Page<Events> findByCharacters(Characters characters, Pageable pageable);

}