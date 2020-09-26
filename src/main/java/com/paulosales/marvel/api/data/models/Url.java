package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class Url implements Serializable {

  private static final long serialVersionUID = -7230638389346931682L;

  private String type;

  private String url;
}
