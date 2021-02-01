package br.com.urbainski.api.marvel.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.ICharactersToCharacterDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageComicsToComicListWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageEventsToEventListWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageSeriesToSerieListWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageStoriesToStoryListWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.dto.CharacterDto;
import br.com.urbainski.api.marvel.dto.ComicListWrapperDto;
import br.com.urbainski.api.marvel.dto.EventListWrapperDto;
import br.com.urbainski.api.marvel.dto.SerieListWrapperDto;
import br.com.urbainski.api.marvel.dto.StoryListWrapperDto;
import br.com.urbainski.api.marvel.service.IComicsService;
import br.com.urbainski.api.marvel.service.IEventsService;
import br.com.urbainski.api.marvel.service.ISeriesService;
import br.com.urbainski.api.marvel.service.IStoriesService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CharactersToCharacterDtoConverterImpl implements ICharactersToCharacterDtoConverter {

    private final @NonNull IComicsService comicsService;
    private final @NonNull IEventsService eventsService;
    private final @NonNull ISeriesService seriesService;
    private final @NonNull IStoriesService storiesService;
    private final @NonNull IPageComicsToComicListWrapperDtoConverter pageComicsToComicListWrapperDtoConverter;
    private final @NonNull IPageEventsToEventListWrapperDtoConverter pageEventsToEventListWrapperDtoConverter;
    private final @NonNull IPageSeriesToSerieListWrapperDtoConverter pageSeriesToSerieListWrapperDtoConverter;
    private final @NonNull IPageStoriesToStoryListWrapperDtoConverter pageStoriesToStoryListWrapperDtoConverter;

    @Override
    public CharacterDto convert(Characters value) {

        final PageRequest pageRequest = PageRequest.of(0, 20);

        final ComicListWrapperDto comicListWrapperDto = getComicListWrapperDto(value, pageRequest);

        final EventListWrapperDto eventListWrapperDto = getEventListWrapperDto(value, pageRequest);

        final SerieListWrapperDto serieListWrapperDto = getSerieListWrapperDto(value, pageRequest);

        final StoryListWrapperDto storyListWrapperDto = getStoryListWrapperDto(value, pageRequest);

        return new CharacterDto(value.getId(), value.getName(), value.getDescription(),
                value.getLastModified(), comicListWrapperDto, serieListWrapperDto, storyListWrapperDto,
                eventListWrapperDto);
    }

    private StoryListWrapperDto getStoryListWrapperDto(Characters characters, PageRequest pageRequest) {

        final Page<Stories> pageStories = storiesService.findByCharacters(characters, pageRequest);

        return pageStoriesToStoryListWrapperDtoConverter.convert(pageStories);
    }

    private SerieListWrapperDto getSerieListWrapperDto(Characters characters, PageRequest pageRequest) {

        final Page<Series> pageSeries = seriesService.findByCharacters(characters, pageRequest);

        return pageSeriesToSerieListWrapperDtoConverter.convert(pageSeries);
    }

    private EventListWrapperDto getEventListWrapperDto(Characters characters, PageRequest pageRequest) {

        final Page<Events> pageEvents = eventsService.findByCharacters(characters, pageRequest);

        return pageEventsToEventListWrapperDtoConverter.convert(pageEvents);
    }

    private ComicListWrapperDto getComicListWrapperDto(Characters characters, PageRequest pageRequest) {

        final Page<Comics> pageComic = comicsService.findByCharacters(characters, pageRequest);

        return pageComicsToComicListWrapperDtoConverter.convert(pageComic);
    }

}