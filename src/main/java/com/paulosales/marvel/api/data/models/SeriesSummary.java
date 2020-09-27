package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("series")
public class SeriesSummary implements Serializable {

  private static final long serialVersionUID = -2585982142299465106L;

  @Id private String id;

  private String resourceURI;

  @Field("title")
  private String name;
}
