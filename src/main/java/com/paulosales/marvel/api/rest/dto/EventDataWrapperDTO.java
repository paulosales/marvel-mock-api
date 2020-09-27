package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "EventDataWrapper")
@Builder
@Data
public class EventDataWrapperDTO {

  @ApiModelProperty(notes = "The HTTP status code of the returned result.", position = 1)
  private Integer code;

  @ApiModelProperty(notes = "A string description of the call status.", position = 2)
  private String status;

  @ApiModelProperty(notes = "The copyright notice for the returned result.", position = 3)
  private String copyright;

  @ApiModelProperty(
      notes =
          "The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.",
      position = 4)
  private String attributionText;

  @ApiModelProperty(
      notes =
          "An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.",
      position = 5)
  private String attributionHTML;

  @ApiModelProperty(notes = "The results returned by the call.", position = 6)
  private EventDataContainerDTO data;

  @ApiModelProperty(notes = "A digest value of the content returned by the call.", position = 7)
  private String etag;
}
