package br.com.urbainski.api.marvel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Events;

@Repository
public interface IEventsRepository extends IDefaultRepository<Events, Long> {

    Page<Events> findByCharacters(Characters characters, Pageable pageable);

}