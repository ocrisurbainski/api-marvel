package br.com.urbainski.api.marvel.endpoint;

import br.com.urbainski.api.marvel.domain.*;
import br.com.urbainski.api.marvel.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1/public/characters")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublicCharactersEndpoint extends AbstractEndpoint {

    private final @NonNull ModelMapper modelMapper;
    private final @NonNull ICharactersService charactersService;
    private final @NonNull IComicsService comicsService;
    private final @NonNull IEventsService eventsService;
    private final @NonNull ISeriesService seriesService;
    private final @NonNull IStoriesService storiesService;

    @GetMapping
    public ResponseEntity<Object> findAll(Pageable pageable) {

        Page<Characters> page = charactersService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

        return noContent();
    }

    @GetMapping("/{id}/comics")
    public ResponseEntity<Object> findComicsByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Comics> page = comicsService.findByCharacters(optionalCharacters.get(), pageable);

            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

        return noContent();
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<Object> findEventsByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Events> page = eventsService.findByCharacters(optionalCharacters.get(), pageable);

            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

        return noContent();
    }

    @GetMapping("/{id}/series")
    public ResponseEntity<Object> findSeriesByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Series> page = seriesService.findByCharacters(optionalCharacters.get(), pageable);

            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

        return noContent();
    }

    @GetMapping("/{id}/stories")
    public ResponseEntity<Object> findStoriesByIdCharacter(@PathVariable("id") Long id, Pageable pageable) {

        Optional<Characters> optionalCharacters = charactersService.findById(id);

        if (optionalCharacters.isPresent()) {

            final Page<Stories> page = storiesService.findByCharacters(optionalCharacters.get(), pageable);

            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

        return noContent();
    }

}