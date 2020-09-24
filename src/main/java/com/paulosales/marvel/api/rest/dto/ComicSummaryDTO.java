package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ComicSummary")
public class ComicSummaryDTO {

  @ApiModelProperty(
      notes = "The path to the individual comic resource.",
      position = 1,
      example = "http://gateway.marvel.com/v1/public/comics/10225")
  private String resourceURI;

  @ApiModelProperty(
      notes = "The canonical name of the comic",
      position = 2,
      example = "Marvel Premiere (1972) #37")
  private String name;
}
