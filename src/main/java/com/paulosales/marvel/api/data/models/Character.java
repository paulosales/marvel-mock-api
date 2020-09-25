package com.paulosales.marvel.api.data.models;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("characters")
public class Character {

  @Id private Long id;

  private String name;

  private String description;

  private Date modified;

  private String resourceURI;
}
