package com.paulosales.marvel.api.rest.resources;

import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
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
    return ResponseEntity.ok().build();
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
  public ResponseEntity<CharacterDataWrapperDTO> getCharacters(
      @PathVariable("characterId") Long characterId) {
    log.debug("Querying character by id {}", characterId);
    return ResponseEntity.ok().build();
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
      @PathVariable("characterId") Long characterId) {
    log.debug("Getting character {} comics", characterId);
    return ResponseEntity.ok().build();
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
      @PathVariable("characterId") Long characterId) {
    log.debug("Getting character {} events", characterId);
    return ResponseEntity.ok().build();
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
      @PathVariable("characterId") Long characterId) {
    log.debug("Getting character {} series", characterId);
    return ResponseEntity.ok().build();
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
      @PathVariable("characterId") Long characterId) {
    log.debug("Getting character {} stories", characterId);
    return ResponseEntity.ok().build();
  }
}
