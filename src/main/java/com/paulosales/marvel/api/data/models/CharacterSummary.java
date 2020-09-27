package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CharacterSummary implements Serializable {

  private static final long serialVersionUID = 5864117905364837164L;

  @Id private String id;

  private String resourceURI;

  private String name;
}
