package com.paulosales.marvel.api.service;

import com.paulosales.marvel.api.data.models.Character;
import java.util.List;

public interface CharacterService {

  public List<Character> getCharacters();
}
