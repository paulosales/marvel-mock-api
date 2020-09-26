package com.paulosales.marvel.api.service.impl;

import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.repositories.CharacterRepository;
import com.paulosales.marvel.api.data.repositories.ComicRepository;
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
}
