package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CreatorSummary")
public class CreatorSummaryDTO {
  @ApiModelProperty(
      notes = "The path to the individual creator resource.",
      position = 1,
      example = "http://gateway.marvel.com/v1/public/creators/2133")
  private String resourceURI;

  @ApiModelProperty(notes = "The full name of the creator.", position = 2, example = "Tom Brevoort")
  private String name;

  @ApiModelProperty(
      notes = "The role of the creator in the parent entity",
      position = 3,
      example = "editor")
  private String role;
}
