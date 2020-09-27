package com.paulosales.marvel.api.unit;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.rest.dto.CharacterDTO;
import com.paulosales.marvel.api.rest.dto.CharacterDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import com.paulosales.marvel.api.rest.resources.CharacterResource;
import com.paulosales.marvel.api.service.CharacterService;
import com.paulosales.marvel.api.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CharacterResourceTest {

  @InjectMocks private CharacterResource characterResource;

  @Mock private CharacterService characterService;

  @Mock private Converter<List<Character>, CharacterDataWrapperDTO> characterConverter;

  @Mock private Converter<List<Comic>, ComicDataWrapperDTO> comicConverter;

  @Mock private Converter<List<Event>, EventDataWrapperDTO> eventConverter;

  @Mock private Converter<List<Series>, SeriesDataWrapperDTO> seriesConverter;

  @Mock private Converter<List<Story>, StoryDataWrapperDTO> storyConverter;

  @Test
  public void testGetCharactersWithSuccess() throws ServiceException {

    List<Character> characters = new ArrayList<>();
    characters.add(Character.builder().id("123456").build());
    Mockito.when(characterService.getCharacters()).thenReturn(characters);

    List<CharacterDTO> charactersDTO = new ArrayList<>();
    charactersDTO.add(CharacterDTO.builder().id("123456").build());
    Mockito.when(characterService.getCharacters()).thenReturn(characters);

    Mockito.when(characterConverter.convert(characters))
        .thenReturn(
            CharacterDataWrapperDTO.builder()
                .status("200")
                .data(CharacterDataContainerDTO.builder().results(charactersDTO).build())
                .build());

    ResponseEntity<CharacterDataWrapperDTO> response = characterResource.getCharacters();

    Assertions.assertNotNull(response);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertNotNull(response.getBody());
    Assertions.assertNotNull(response.getBody().getData());
    Assertions.assertNotNull(response.getBody().getData().getResults());
    Assertions.assertEquals(1, response.getBody().getData().getResults().size());
    Assertions.assertEquals("123456", response.getBody().getData().getResults().get(0).getId());
  }

  @Test
  public void testGetCharactersWithServiceException() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacters();

    ResponseEntity<CharacterDataWrapperDTO> response = characterResource.getCharacters();

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }

  @Test
  public void testGetCharacterWithSuccess() throws ServiceException {

    Character character = Character.builder().id("123456").build();
    Mockito.when(characterService.getCharacter("123456")).thenReturn(character);

    List<CharacterDTO> charactersDTO = new ArrayList<>();
    charactersDTO.add(CharacterDTO.builder().id("123456").build());

    Mockito.when(characterConverter.convert(Arrays.asList(character)))
        .thenReturn(
            CharacterDataWrapperDTO.builder()
                .status("200")
                .data(CharacterDataContainerDTO.builder().results(charactersDTO).build())
                .build());

    ResponseEntity<CharacterDataWrapperDTO> response = characterResource.getCharacter("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertNotNull(response.getBody());
    Assertions.assertNotNull(response.getBody().getData());
    Assertions.assertNotNull(response.getBody().getData().getResults());
    Assertions.assertEquals(1, response.getBody().getData().getResults().size());
    Assertions.assertEquals("123456", response.getBody().getData().getResults().get(0).getId());
  }

  @Test
  public void testGetCharacterWithServiceException() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacter(Mockito.anyString());

    ResponseEntity<CharacterDataWrapperDTO> response = characterResource.getCharacter("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }

  @Test
  public void testGetCharacterComicsWithSuccess() throws ServiceException {

    List<Comic> comics = new ArrayList<>();
    comics.add(Comic.builder().id("123456").build());
    Mockito.when(characterService.getCharacterComics("123456")).thenReturn(comics);

    List<ComicDTO> comicsDTO = new ArrayList<>();
    comicsDTO.add(ComicDTO.builder().id("123456").build());

    Mockito.when(comicConverter.convert(comics))
        .thenReturn(
            ComicDataWrapperDTO.builder()
                .status("200")
                .data(ComicDataContainerDTO.builder().results(comicsDTO).build())
                .build());

    ResponseEntity<ComicDataWrapperDTO> response = characterResource.getComics("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertNotNull(response.getBody());
  }

  @Test
  public void testGetCharacterComicsWithFailure() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacterComics(Mockito.anyString());

    ResponseEntity<ComicDataWrapperDTO> response = characterResource.getComics("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }

  @Test
  public void testGetCharacterEventsWithSuccess() {

    ResponseEntity<EventDataWrapperDTO> response = characterResource.getEvents("132132");

    Assertions.assertNotNull(response);
  }

  @Test
  public void testGetCharacterEventsWithFailure() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacterEvents(Mockito.anyString());

    ResponseEntity<EventDataWrapperDTO> response = characterResource.getEvents("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }

  @Test
  public void testGetCharacterSeriesWithSuccess() {

    ResponseEntity<SeriesDataWrapperDTO> response = characterResource.getSeries("132132");

    Assertions.assertNotNull(response);
  }

  @Test
  public void testGetCharacterSeriesWithFailure() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacterSeries(Mockito.anyString());

    ResponseEntity<SeriesDataWrapperDTO> response = characterResource.getSeries("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }

  @Test
  public void testGetCharacterStoriesWithSuccess() {

    ResponseEntity<StoryDataWrapperDTO> response = characterResource.getStories("132132");

    Assertions.assertNotNull(response);
  }

  @Test
  public void testGetCharacterStoriesWithFailure() throws ServiceException {

    Mockito.doThrow(new ServiceException("Service layer error", null))
        .when(characterService)
        .getCharacterStories(Mockito.anyString());

    ResponseEntity<StoryDataWrapperDTO> response = characterResource.getStories("123456");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(500, response.getStatusCodeValue());
    Assertions.assertNull(response.getBody());
  }
}
