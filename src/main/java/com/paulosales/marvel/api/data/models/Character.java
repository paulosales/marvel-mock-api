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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("characters")
public class Character implements Serializable {

  private static final long serialVersionUID = -7706307953753229438L;

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
