package com.paulosales.marvel.api.data.repositories;

import com.paulosales.marvel.api.data.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {}
