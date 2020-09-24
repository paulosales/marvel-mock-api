package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SeriesSummary")
public class SeriesSummaryDTO {

  @ApiModelProperty(
      notes = "The path to the individual series resource.",
      position = 1,
      example = "http://gateway.marvel.com/v1/public/series/1945")
  private String resourceURI;

  @ApiModelProperty(
      notes = "The canonical name of the series.",
      position = 2,
      example = "Avengers: The Initiative (2007 - 2010)")
  private String name;
}
