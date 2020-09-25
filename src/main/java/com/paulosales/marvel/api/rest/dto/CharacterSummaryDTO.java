package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "CharacterSummary")
@Data
public class CharacterSummaryDTO {
  @ApiModelProperty(
      notes = "The path to the individual character resource.",
      position = 1,
      example = "http://gateway.marvel.com/v1/public/characters/1011334")
  private String resourceURI;

  @ApiModelProperty(notes = "The full name of the character.", position = 2, example = "3-D Man")
  private String name;
}
