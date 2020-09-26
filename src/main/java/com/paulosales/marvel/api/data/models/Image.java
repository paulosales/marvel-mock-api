package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class Image implements Serializable {

  private static final long serialVersionUID = 8169498076846213808L;

  private String path;

  private String extension;
}
