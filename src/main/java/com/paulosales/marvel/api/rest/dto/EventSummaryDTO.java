package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EventSummary")
public class EventSummaryDTO {
  @ApiModelProperty(
      notes = "The path to the individual event resource.",
      position = 1,
      example = "The path to the individual event resource.")
  private String resourceURI;

  @ApiModelProperty(
      notes = "The name of the event",
      position = 2,
      example = "The name of the event.")
  private String name;
}
