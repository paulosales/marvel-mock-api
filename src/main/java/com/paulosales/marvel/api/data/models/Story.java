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
@NoArgsConstructor
@AllArgsConstructor
@Document("stories")
public class Story implements Serializable {

  private static final long serialVersionUID = -7885210956153026806L;

  @Id private String id;

  private String title;

  private String description;

  private String resourceURI;

  private String type;

  private Date modified;

  private Image thumbnail;

  @DBRef private List<ComicSummary> comics;

  @DBRef private List<SeriesSummary> series;

  @DBRef private List<EventSummary> events;

  @DBRef private List<CharacterSummary> characters;

  @DBRef private List<CreatorSummary> creators;

  private ComicSummary originalissue;
}
