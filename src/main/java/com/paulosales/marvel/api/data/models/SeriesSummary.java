package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("series")
public class SeriesSummary implements Serializable {

  private static final long serialVersionUID = -2585982142299465106L;

  private String resourceURI;

  @Field("title")
  private String name;
}
