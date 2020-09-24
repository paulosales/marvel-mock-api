package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "StoryList")
public class StoryListDTO {

  @ApiModelProperty(
      notes =
          "The number of total available stories in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "21")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of stories returned in this collection (up to 20).",
      position = 2,
      example = "20")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of stories in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/stories/54371")
  private String collectionURI;

  @ApiModelProperty(notes = "The list of returned stories in this collection.", position = 4)
  private List<StorySummaryDTO> items;
}
