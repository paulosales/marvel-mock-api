package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "CharacterDataContainer")
public class CharacterDataContainerDTO {

  @ApiModelProperty(notes = "The requested offset (number of skipped results) of the call.")
  private Integer offset;

  @ApiModelProperty(notes = "The requested result limit.")
  private Integer limit;

  @ApiModelProperty(notes = "The total number of resources available given the current filter set.")
  private Integer total;

  @ApiModelProperty(notes = "The total number of results returned by this call.")
  private Integer count;

  @ApiModelProperty(notes = "The list of characters returned by the call.")
  private List<CharacterDTO> results;
}
