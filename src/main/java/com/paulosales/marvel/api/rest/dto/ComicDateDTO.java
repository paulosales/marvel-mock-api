package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@ApiModel(value = "ComicDate")
public class ComicDateDTO {

  @ApiModelProperty(
      notes = "A description of the date (e.g. onsale date, FOC date).",
      position = 1,
      example = "onsaleDate")
  private String type;

  @ApiModelProperty(notes = "The date", position = 2, example = "2008-12-17T00:00:00-0500")
  private Date date;
}
