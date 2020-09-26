package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@ApiModel("ComicDataContainer")
@Builder
@Data
public class ComicDataContainerDTO {

  @ApiModelProperty(
      notes = "The requested offset (number of skipped results) of the call.",
      position = 1,
      example = "0")
  private Integer offset;

  @ApiModelProperty(notes = "The requested result limit.", position = 2, example = "20")
  private Integer limit;

  @ApiModelProperty(
      notes = "The total number of resources available given the current filter set.",
      position = 3,
      example = "12")
  private Integer total;

  @ApiModelProperty(
      notes = "The total number of results returned by this call.",
      position = 4,
      example = "12")
  private Integer count;

  @ApiModelProperty(notes = "The list of comics returned by the call", position = 5)
  private List<ComicDTO> results;
}
