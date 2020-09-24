package com.paulosales.marvel.api.data.models;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Character {

  @Id private Long id;

  private String name;

  private String description;

  private Date modified;

  private String resourceURI;
}
