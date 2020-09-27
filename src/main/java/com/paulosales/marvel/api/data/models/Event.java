package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("events")
public class Event implements Serializable {

  private static final long serialVersionUID = -6901395094155482979L;

  @Id private String id;

  private String title;

  private String description;

  private String resourceURI;

  private List<Url> urls;

  private Date modified;

  private Date start;

  private Date end;

  private Image thumbnail;

  @DBRef private List<ComicSummary> comics;

  @DBRef private List<StorySummary> stories;

  @DBRef private List<SeriesSummary> series;

  @DBRef private List<CharacterSummary> characters;

  @DBRef private List<CreatorSummary> creators;

  private EventSummary next;

  private EventSummary previous;
}
