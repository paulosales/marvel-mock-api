package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("series")
public class Series implements Serializable {

  private static final long serialVersionUID = -406268476545997696L;

  @Id private String id;

  private String title;

  private String description;

  private String resourceURI;

  private List<Url> urls;

  private Integer startYear;

  private Integer endYear;

  private String rating;

  private Date modified;

  private Image thumbnail;

  @DBRef private List<ComicSummary> comics;

  @DBRef private List<StorySummary> stories;

  @DBRef private List<EventSummary> events;

  @DBRef private List<CharacterSummary> characters;

  @DBRef private List<CreatorSummary> creators;

  private SeriesSummary next;

  private SeriesSummary previous;
}
