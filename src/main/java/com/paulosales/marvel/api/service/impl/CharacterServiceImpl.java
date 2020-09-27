package com.paulosales.marvel.api.service.impl;

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
import com.paulosales.marvel.api.service.CharacterService;
import com.paulosales.marvel.api.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

  @Autowired private CharacterRepository characterRepository;
  @Autowired private ComicRepository comicRepository;
  @Autowired private EventRepository eventRepository;
  @Autowired private SeriesRepository seriesRepository;
  @Autowired private StoryRepository storyRepository;

  @Override
  @Cacheable(value = "characters-list")
  public List<Character> getCharacters() throws ServiceException {
    return characterRepository.findAll();
  }

  @Override
  @Cacheable(value = "character")
  public Character getCharacter(String id) throws ServiceException {
    if (id == null) return null;
    return characterRepository.findById(id).get();
  }

  @Override
  public List<Comic> getCharacterComics(String id) throws ServiceException {
    if (id == null) return Arrays.<Comic>asList();

    Optional<Character> optionalCharacter = characterRepository.findById(id);

    List<Comic> comics = new ArrayList<Comic>();
    if (optionalCharacter.isPresent()) {
      Character character = optionalCharacter.get();

      List<String> ids =
          character.getComics().stream().map(comic -> comic.getId()).collect(Collectors.toList());

      Iterable<Comic> comicIt = comicRepository.findAllById(ids);

      comicIt.forEach(comics::add);
    }
    return comics;
  }

  @Override
  public List<Event> getCharacterEvents(String id) throws ServiceException {
    if (id == null) return Arrays.<Event>asList();

    Optional<Character> optionalCharacter = characterRepository.findById(id);

    List<Event> events = new ArrayList<Event>();
    if (optionalCharacter.isPresent()) {
      Character character = optionalCharacter.get();

      List<String> ids =
          character.getEvents().stream().map(event -> event.getId()).collect(Collectors.toList());

      Iterable<Event> eventIt = eventRepository.findAllById(ids);

      eventIt.forEach(events::add);
    }
    return events;
  }

  @Override
  public List<Series> getCharacterSeries(String id) throws ServiceException {
    if (id == null) return Arrays.<Series>asList();

    Optional<Character> optionalCharacter = characterRepository.findById(id);

    List<Series> series = new ArrayList<Series>();
    if (optionalCharacter.isPresent()) {
      Character character = optionalCharacter.get();

      List<String> ids =
          character.getSeries().stream().map(serie -> serie.getId()).collect(Collectors.toList());

      Iterable<Series> seriesIt = seriesRepository.findAllById(ids);

      seriesIt.forEach(series::add);
    }
    return series;
  }

  @Override
  public List<Story> getCharacterStories(String id) throws ServiceException {
    if (id == null) return Arrays.<Story>asList();

    Optional<Character> optionalCharacter = characterRepository.findById(id);

    List<Story> stories = new ArrayList<Story>();
    if (optionalCharacter.isPresent()) {
      Character character = optionalCharacter.get();

      List<String> ids =
          character.getStories().stream().map(story -> story.getId()).collect(Collectors.toList());

      Iterable<Story> storyIt = storyRepository.findAllById(ids);

      storyIt.forEach(stories::add);
    }
    return stories;
  }
}
