package com.paulosales.marvel.api.data.repositories;

import com.paulosales.marvel.api.data.models.Comic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComicRepository extends MongoRepository<Comic, String> {}
