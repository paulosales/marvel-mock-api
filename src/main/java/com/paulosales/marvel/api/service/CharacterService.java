package com.paulosales.marvel.api.service;

import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.service.exception.ServiceException;
import java.util.List;

/** Bussiness rules related to Character */
public interface CharacterService {

  /**
   * The characters list
   *
   * @return List of characters
   */
  public List<Character> getCharacters() throws ServiceException;

  /**
   * Get one character by id.
   *
   * @param id Character id.
   */
  public Character getCharacter(String id) throws ServiceException;

  /**
   * The character's comics list.
   *
   * @param id Character id
   * @return List of comics of the specified character.
   */
  public List<Comic> getCharacterComics(String id) throws ServiceException;
}
