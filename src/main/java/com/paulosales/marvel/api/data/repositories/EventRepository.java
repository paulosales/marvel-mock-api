package com.paulosales.marvel.api.data.repositories;

import com.paulosales.marvel.api.data.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {}
