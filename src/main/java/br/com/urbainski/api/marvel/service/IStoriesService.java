package br.com.urbainski.api.marvel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Stories;

public interface IStoriesService extends IDefaultService<Stories, Long> {

    Page<Stories> findByCharacters(Characters characters, Pageable pageable);

}
