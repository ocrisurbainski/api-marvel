package br.com.urbainski.api.marvel.service.impl;

import org.springframework.stereotype.Service;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.service.ICharactersService;

@Service
public class CharactersServiceImpl extends AbstractDefaultServiceImpl<Characters, Long> implements ICharactersService {

}