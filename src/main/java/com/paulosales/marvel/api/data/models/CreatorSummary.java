package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class CreatorSummary implements Serializable {

  private static final long serialVersionUID = 5125326916934227597L;

  private String resourceURI;

  private String name;

  private String role;
}
