package com.paulosales.marvel.api.data.models;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("comics")
public class Comic {

  private String id;

  private Long digitalId;

  private String title;

  private Double issueNumber;

  private String variantDescription;

  private String description;

  private Date modified;

  private String isbn;

  private String upc;

  private String diamondCode;

  private String ean;

  private String issn;

  private String format;

  private Integer pageCount;

  private List<TextObject> textObjects;

  private String resourceURI;

  private List<Url> urls;

  @DBRef private SeriesSummary series;

  @DBRef private List<ComicSummary> variants;

  @DBRef private List<ComicSummary> collections;

  @DBRef private List<ComicSummary> collectedIssues;

  private List<ComicDate> dates;

  private List<ComicPrice> prices;

  private Image thumbnail;

  private List<Image> images;

  private List<CreatorSummary> creators;

  @DBRef private List<CharacterSummary> characters;

  @DBRef private List<StorySummary> stories;

  @DBRef private List<EventSummary> events;
}
