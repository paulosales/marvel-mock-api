package com.paulosales.marvel.api.rest.resources;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import com.paulosales.marvel.api.service.CharacterService;
import com.paulosales.marvel.api.service.exception.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Cache: https://medium.com/@MatthewFTech/spring-boot-cache-with-redis-56026f7da83a
@Slf4j
@RestController
@RequestMapping("characters")
@Api(tags = "character")
public class CharacterResource {

  @Autowired private CharacterService characterService;

  @Autowired
  @Qualifier("characterDataWrapperConverter")
  private Converter<List<Character>, CharacterDataWrapperDTO> characterConverter;

  @Autowired
  @Qualifier("comicDataWrapperConverter")
  private Converter<List<Comic>, ComicDataWrapperDTO> comicConverter;

  @Autowired
  @Qualifier("eventDataWrapperConverter")
  private Converter<List<Event>, EventDataWrapperDTO> eventConverter;

  @Autowired
  @Qualifier("seriesDataWrapperConverter")
  private Converter<List<Series>, SeriesDataWrapperDTO> seriesConverter;

  @Autowired
  @Qualifier("storyDataWrapperConverter")
  private Converter<List<Story>, StoryDataWrapperDTO> storyConverter;

  @GetMapping
  @ApiOperation(
      nickname = "getCharacters",
      value =
          "Fetches lists of comic characters with optional filters. See notes on individual parameters below.")
  @ApiResponses({
    @ApiResponse(
        code = 409,
        message =
            "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter.")
  })
  public ResponseEntity<CharacterDataWrapperDTO> getCharacters() {
    log.debug("Querying characters");
    try {
      CharacterDataWrapperDTO response =
          characterConverter.convert(characterService.getCharacters());
      log.debug("Querying characters with success");
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Querying characters"), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/{characterId}")
  @ApiOperation(
      nickname = "getCharacter",
      value =
          "This method fetches a single character resource. It is the canonical URI for any character resource provided by the API.")
  @ApiResponses({
    @ApiResponse(
        code = 409,
        message =
            "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter.")
  })
  public ResponseEntity<CharacterDataWrapperDTO> getCharacter(
      @PathVariable("characterId") String characterId) {
    log.debug("Querying character by id {}", characterId);
    try {
      CharacterDataWrapperDTO response =
          characterConverter.convert(
              Arrays.<Character>asList(characterService.getCharacter(characterId)));
      log.debug("Querying character by id {} with success", characterId);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Querying character %s error", characterId), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/{characterId}/comics")
  @ApiOperation(
      nickname = "getComics",
      value =
          "Fetches lists of comics containing a specific character, with optional filters. See notes on individual parameters below.")
  @ApiResponses({
    @ApiResponse(
        code = 409,
        message =
            "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter.")
  })
  public ResponseEntity<ComicDataWrapperDTO> getComics(
      @PathVariable("characterId") String characterId) {

    log.debug("Getting character {} comics", characterId);
    try {
      ComicDataWrapperDTO response =
          comicConverter.convert(characterService.getCharacterComics(characterId));
      log.debug("Getting character {} comics with success", characterId);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Getting character %s comics error", characterId), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/{characterId}/events")
  @ApiOperation(
      nickname = "getEvents",
      value =
          "Fetches lists of events in which a specific character appears, with optional filters. See notes on individual parameters below.")
  @ApiResponses(
      @ApiResponse(
          code = 409,
          message =
              "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter."))
  public ResponseEntity<EventDataWrapperDTO> getEvents(
      @PathVariable("characterId") String characterId) {
    log.debug("Getting character {} events", characterId);
    try {
      EventDataWrapperDTO response =
          eventConverter.convert(characterService.getCharacterEvents(characterId));
      log.debug("Getting character {} events with success", characterId);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Getting character %s events error", characterId), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/{characterId}/series")
  @ApiOperation(
      nickname = "getSeries",
      value =
          "Fetches lists of comic series in which a specific character appears, with optional filters. See notes on individual parameters below.")
  @ApiResponses(
      @ApiResponse(
          code = 409,
          message =
              "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter."))
  public ResponseEntity<SeriesDataWrapperDTO> getSeries(
      @PathVariable("characterId") String characterId) {
    log.debug("Getting character {} series", characterId);
    try {
      SeriesDataWrapperDTO response =
          seriesConverter.convert(characterService.getCharacterSeries(characterId));
      log.debug("Getting character {} series with success", characterId);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Getting character %s series error", characterId), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/{characterId}/stories")
  @ApiOperation(
      nickname = "getStories",
      value =
          "Fetches lists of comic stories featuring a specific character with optional filters. See notes on individual parameters below.")
  @ApiResponses(
      @ApiResponse(
          code = 409,
          message =
              "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter."))
  public ResponseEntity<StoryDataWrapperDTO> getStories(
      @PathVariable("characterId") String characterId) {
    log.debug("Getting character {} stories", characterId);
    try {
      StoryDataWrapperDTO response =
          storyConverter.convert(characterService.getCharacterStories(characterId));
      log.debug("Getting character {} stories with success", characterId);
      return ResponseEntity.ok().body(response);
    } catch (ServiceException e) {
      log.error(String.format("Getting character %s stories error", characterId), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
