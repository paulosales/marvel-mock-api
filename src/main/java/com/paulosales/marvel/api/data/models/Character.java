package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("characters")
public class Character implements Serializable {

  private static final long serialVersionUID = -7706307953753229438l;

  @Id private String id;

  private String name;

  private String description;

  private Date modified;

  private String resourceURI;

  private List<Url> urls;

  private Image thumbnail;

  @DBRef private List<ComicSummary> comics;

  @DBRef private List<StorySummary> stories;

  @DBRef private List<EventSummary> events;

  @DBRef private List<SeriesSummary> series;
}
