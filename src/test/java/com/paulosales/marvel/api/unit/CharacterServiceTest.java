package com.paulosales.marvel.api.unit;

import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.data.repositories.CharacterRepository;
import com.paulosales.marvel.api.data.repositories.ComicRepository;
import com.paulosales.marvel.api.data.repositories.EventRepository;
import com.paulosales.marvel.api.data.repositories.SeriesRepository;
import com.paulosales.marvel.api.data.repositories.StoryRepository;
import com.paulosales.marvel.api.service.exception.ServiceException;
import com.paulosales.marvel.api.service.impl.CharacterServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CharacterServiceTest {

  @InjectMocks private CharacterServiceImpl service;

  @Mock private CharacterRepository characterRepository;
  @Mock private ComicRepository comicRepository;
  @Mock private EventRepository eventRepository;
  @Mock private SeriesRepository seriesRepository;
  @Mock private StoryRepository storyRepository;

  @Test
  public void testGetCharactersWithSucess() throws ServiceException {

    List<Character> characters = service.getCharacters();

    Assertions.assertNotNull(characters);
  }

  @Test
  public void testGetCharacterWithSucess() throws ServiceException {

    Optional<Character> characterOptional = Optional.of(Character.builder().id("123456").build());
    Mockito.when(characterRepository.findById("123456")).thenReturn(characterOptional);
    Character character = service.getCharacter("123456");

    Assertions.assertNotNull(character);
  }

  @Test
  public void testGetStoriesWithSucess() throws ServiceException {

    List<Story> stories = service.getCharacterStories("123456");

    Assertions.assertNotNull(stories);
  }

  @Test
  public void testGetSeriesWithSucess() throws ServiceException {

    List<Series> series = service.getCharacterSeries("123456");

    Assertions.assertNotNull(series);
  }

  @Test
  public void testGetEventsWithSucess() throws ServiceException {

    List<Event> events = service.getCharacterEvents("123456");

    Assertions.assertNotNull(events);
  }

  @Test
  public void testGetComicsWithSucess() throws ServiceException {

    List<Comic> comics = service.getCharacterComics("123456");

    Assertions.assertNotNull(comics);
  }
}
