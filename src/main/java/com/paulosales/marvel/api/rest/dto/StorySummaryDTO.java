package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("StorySummary")
public class StorySummaryDTO {
  @ApiModelProperty(
      notes = "The path to the individual story resource.",
      position = 1,
      example = "http://gateway.marvel.com/v1/public/stories/54371")
  private String resourceURI;

  @ApiModelProperty(
      notes = "The canonical name of the story.",
      position = 2,
      example = "Avengers: The Initiative (2007) #14, Spotlight Variant - Int")
  private String name;

  @ApiModelProperty(
      notes = "The type of the story (interior or cover)",
      position = 3,
      example = "interiorStory")
  private String type;
}
