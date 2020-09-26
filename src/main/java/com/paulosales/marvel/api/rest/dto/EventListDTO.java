package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "EventList")
public class EventListDTO {
  @ApiModelProperty(
      notes =
          "The number of total available events in this list. Will always be greater than or equal to the \"returned\" value.",
      position = 1,
      example = "1")
  private Integer available;

  @ApiModelProperty(
      notes = "The number of events returned in this collection (up to 20).",
      position = 2,
      example = "1")
  private Integer returned;

  @ApiModelProperty(
      notes = "The path to the full list of events in this collection.",
      position = 3,
      example = "http://gateway.marvel.com/v1/public/characters/1011334/events")
  private String collectionURI;

  @ApiModelProperty(notes = "The list of returned events in this collection.", position = 4)
  private List<EventSummaryDTO> items;
}
