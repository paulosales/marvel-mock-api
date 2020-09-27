package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class TextObject implements Serializable {

  private static final long serialVersionUID = 1055169230686313597L;

  private String type;

  private String language;

  private String text;
}
