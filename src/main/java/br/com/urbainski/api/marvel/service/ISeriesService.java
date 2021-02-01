package br.com.urbainski.api.marvel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Series;

public interface ISeriesService extends IDefaultService<Series, Long> {

    Page<Series> findByCharacters(Characters characters, Pageable pageable);

}