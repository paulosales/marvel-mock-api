package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@ApiModel("CreatorList")
public class CreatorListDTO {

  @ApiModelProperty(
      notes =
          "The number of total available creators in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "9")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of creators returned in this collection (up to 20).",
      position = 2,
      example = "9")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of creators in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/comics/22506/creators")
  private String collectionURI;

  @ApiModelProperty(notes = "The list of returned creators in this collection.", position = 4)
  private List<CreatorSummaryDTO> items;
}
