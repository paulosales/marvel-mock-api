package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "ComicList")
public class ComicListDTO {

  @ApiModelProperty(
      notes =
          "The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "12")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of issues returned in this collection (up to 20).",
      position = 2,
      example = "12")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of issues in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/characters/1011334/comics")
  private String collectionURI;

  @ApiModelProperty(notes = "The list of returned issues in this collection", position = 4)
  private List<ComicSummaryDTO> items;
}
