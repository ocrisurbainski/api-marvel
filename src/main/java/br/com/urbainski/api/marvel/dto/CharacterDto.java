package br.com.urbainski.api.marvel.dto;

import java.time.LocalDateTime;

public record CharacterDto(Long id, String name, String description, LocalDateTime lastModified, ComicListWrapperDto comics, SerieListWrapperDto series, StoryListWrapperDto stories, EventListWrapperDto events) {

}