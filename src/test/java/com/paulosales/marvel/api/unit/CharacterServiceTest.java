package com.paulosales.marvel.api.unit;

import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.data.repositories.CharacterRepository;
import com.paulosales.marvel.api.data.repositories.ComicRepository;
import com.paulosales.marvel.api.data.repositories.EventRepository;
import com.paulosales.marvel.api.data.repositories.SeriesRepository;
import com.paulosales.marvel.api.data.repositories.StoryRepository;
import com.paulosales.marvel.api.service.exception.ServiceException;
import com.paulosales.marvel.api.service.impl.CharacterServiceImpl;
import java.util.ArrayList;
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

    List<StorySummary> stories = new ArrayList<>();
    stories.add(StorySummary.builder().build());
    Optional<Character> characterOptional =
        Optional.of(Character.builder().id("123456").stories(stories).build());
    Mockito.when(characterRepository.findById("123456")).thenReturn(characterOptional);

    List<Story> storiesResult = service.getCharacterStories("123456");

    Assertions.assertNotNull(storiesResult);
  }

  @Test
  public void testGetSeriesWithSucess() throws ServiceException {

    List<SeriesSummary> series = new ArrayList<>();
    series.add(SeriesSummary.builder().build());
    Optional<Character> characterOptional =
        Optional.of(Character.builder().id("123456").series(series).build());
    Mockito.when(characterRepository.findById("123456")).thenReturn(characterOptional);
    List<Series> seriesResult = service.getCharacterSeries("123456");

    Assertions.assertNotNull(seriesResult);
  }

  @Test
  public void testGetEventsWithSucess() throws ServiceException {

    List<EventSummary> events = new ArrayList<>();
    events.add(EventSummary.builder().build());
    Optional<Character> characterOptional =
        Optional.of(Character.builder().id("123456").events(events).build());
    Mockito.when(characterRepository.findById("123456")).thenReturn(characterOptional);
    List<Event> eventsResult = service.getCharacterEvents("123456");

    Assertions.assertNotNull(eventsResult);
  }

  @Test
  public void testGetComicsWithSucess() throws ServiceException {

    List<ComicSummary> comics = new ArrayList<>();
    comics.add(ComicSummary.builder().build());
    Optional<Character> characterOptional =
        Optional.of(Character.builder().id("123456").comics(comics).build());
    Mockito.when(characterRepository.findById("123456")).thenReturn(characterOptional);
    List<Comic> comicsResult = service.getCharacterComics("123456");

    Assertions.assertNotNull(comicsResult);
  }
}
