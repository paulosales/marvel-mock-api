package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "StoryDataContainer")
public class StoryDataContainerDTO {
  @ApiModelProperty(
      notes = "The requested offset (number of skipped results) of the call.",
      position = 1)
  private Integer offset;

  @ApiModelProperty(notes = "The requested result limit.", position = 2)
  private Integer limit;

  @ApiModelProperty(
      notes = "The total number of resources available given the current filter set.",
      position = 3)
  private Integer total;

  @ApiModelProperty(notes = "The total number of results returned by this call.", position = 4)
  private Integer count;

  @ApiModelProperty(notes = "The list of events returned by the call.", position = 5)
  List<StoryDTO> results;
}
