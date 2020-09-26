package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "CharacterList")
public class CharacterListDTO {
  @ApiModelProperty(
      notes =
          "The number of total available characters in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "8")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of characters returned in this collection (up to 20).",
      position = 2,
      example = "8")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of characters in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/comics/22506/characters")
  private String collectionURI;

  @ApiModelProperty(notes = ": The list of returned characters in this collection.", position = 4)
  private List<CharacterSummaryDTO> items;
}
