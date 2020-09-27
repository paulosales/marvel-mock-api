package com.paulosales.marvel.api.data.repositories;

import com.paulosales.marvel.api.data.models.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, String> {}
