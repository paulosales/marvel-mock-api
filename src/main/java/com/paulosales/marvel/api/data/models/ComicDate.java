package com.paulosales.marvel.api.data.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ComicDate implements Serializable {

  private static final long serialVersionUID = 4140896810057085997L;

  private String type;

  private Date date;
}
