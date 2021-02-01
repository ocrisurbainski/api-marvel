package br.com.urbainski.api.marvel.endpoint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urbainski.api.marvel.converter.IPageCharactersToCharacterContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageComicsToComicContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageEventsToEventContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageSeriesToSerieContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageStoriesToStoryContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.service.ICharactersService;
import br.com.urbainski.api.marvel.service.IComicsService;
import br.com.urbainski.api.marvel.service.IEventsService;
import br.com.urbainski.api.marvel.service.ISeriesService;
import br.com.urbainski.api.marvel.service.IStoriesService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/public/characters")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublicCharactersEndpoint extends AbstractEndpoint {

    private final @NonNull ICharactersService charactersService;
    private final @NonNull IComicsService comicsService;
    private final @NonNull IEventsService eventsService;
    private final @NonNull ISeriesService seriesService;
    private final @NonNull IStoriesService storiesService;
    private final @NonNull IPageCharactersToCharacterContainerWrapperDtoConverter pageCharactersToCharacterContainerWrapperDtoConverter;
    private final @NonNull IPageComicsToComicContainerWrapperDtoConverter pageComicsToComicContainerWrapperDtoConverter;
    private final @NonNull IPageEventsToEventContainerWrapperDtoConverter pageEventsToEventContainerWrapperDtoConverter;
    private final @NonNull IPageSeriesToSerieContainerWrapperDtoConverter pageSeriesToSerieContainerWrapperDtoConverter;
    private final @NonNull IPageStoriesToStoryContainerWrapperDtoConverter pageStoriesToStoryContainerWrapperDtoConverter;

    @GetMapping
    public ResponseEntity<Object> findAll(Pageable pageable) {

        Page<Characters> page = charactersService.findAll(pageable);

        return ok(pageCharactersToCharacterContainerWrapperDtoConverter.convert(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            Page<Characters> page = new PageImpl<>(List.of(optionalCharacters.get()), PageRequest.of(1, 1), 1);

            return ok(pageCharactersToCharacterContainerWrapperDtoConverter.convert(page));
        }

        return noContent();
    }

    @GetMapping("/{id}/comics")
    public ResponseEntity<Object> findComicsByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Comics> page = comicsService.findByCharacters(optionalCharacters.get(), pageable);

            return ok(pageComicsToComicContainerWrapperDtoConverter.convert(page));
        }

        return noContent();
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<Object> findEventsByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Events> page = eventsService.findByCharacters(optionalCharacters.get(), pageable);

            return ok(pageEventsToEventContainerWrapperDtoConverter.convert(page));
        }

        return noContent();
    }

    @GetMapping("/{id}/series")
    public ResponseEntity<Object> findSeriesByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Series> page = seriesService.findByCharacters(optionalCharacters.get(), pageable);

            return ok(pageSeriesToSerieContainerWrapperDtoConverter.convert(page));
        }

        return noContent();
    }

    @GetMapping("/{id}/stories")
    public ResponseEntity<Object> findStoriesByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Stories> page = storiesService.findByCharacters(optionalCharacters.get(), pageable);

            return ok(pageStoriesToStoryContainerWrapperDtoConverter.convert(page));
        }

        return noContent();
    }

}