package com.paulosales.marvel.api.service.impl;

import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.repositories.CharacterRepository;
import com.paulosales.marvel.api.service.CharacterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

  @Autowired private CharacterRepository repository;

  @Override
  public List<Character> getCharacters() {
    return repository.findAll();
  }
}
