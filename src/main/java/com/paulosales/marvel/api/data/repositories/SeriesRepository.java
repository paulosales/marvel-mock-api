package com.paulosales.marvel.api.data.repositories;

import com.paulosales.marvel.api.data.models.Series;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<Series, String> {}
