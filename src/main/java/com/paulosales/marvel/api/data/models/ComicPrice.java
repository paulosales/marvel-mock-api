package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class ComicPrice implements Serializable {

  private static final long serialVersionUID = 1L;

  private String type;

  private Double price;
}
