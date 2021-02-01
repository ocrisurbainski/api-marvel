package br.com.urbainski.api.marvel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Series;

@Repository
public interface ISeriesRepository extends IDefaultRepository<Series, Long> {

    Page<Series> findByCharacters(Characters characters, Pageable pageable);

}