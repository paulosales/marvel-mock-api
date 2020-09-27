package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("events")
public class EventSummary implements Serializable {

  private static final long serialVersionUID = 2523654780481612314L;

  @Id private String id;

  private String resourceURI;

  @Field("title")
  private String name;
}
