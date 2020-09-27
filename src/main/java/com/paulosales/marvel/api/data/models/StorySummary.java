package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("stories")
public class StorySummary implements Serializable {

  private static final long serialVersionUID = 2947614404811743324L;

  @Id private String id;

  private String resourceURI;

  @Field("title")
  private String name;

  private String type;
}
