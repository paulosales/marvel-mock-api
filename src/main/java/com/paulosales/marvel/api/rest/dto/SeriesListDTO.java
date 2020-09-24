package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SeriesList")
public class SeriesListDTO {

  @ApiModelProperty(
      notes =
          "The number of total available series in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "1")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of series returned in this collection (up to 20).",
      position = 2,
      example = "1")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of series in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/characters/1011334/series")
  private String collectionURI;

  @ApiModelProperty(notes = "The list of returned series in this collection.", position = 4)
  private SeriesSummaryDTO items;
}
