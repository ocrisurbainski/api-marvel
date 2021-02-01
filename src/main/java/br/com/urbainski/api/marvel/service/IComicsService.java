package br.com.urbainski.api.marvel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Comics;

public interface IComicsService extends IDefaultService<Comics, Long> {

    Page<Comics> findByCharacters(Characters characters, Pageable pageable);

}