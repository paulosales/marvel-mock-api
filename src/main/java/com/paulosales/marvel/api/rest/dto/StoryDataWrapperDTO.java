package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "StoryDataWrapper")
public class StoryDataWrapperDTO {
  @ApiModelProperty(
      notes = "The HTTP status code of the returned result.",
      position = 1,
      example = "200")
  private Integer code;

  @ApiModelProperty(
      notes = "A string description of the call status.",
      position = 2,
      example = "Ok")
  private String status;

  @ApiModelProperty(
      notes = "The copyright notice for the returned result.",
      position = 3,
      example = "© 2020 MARVEL")
  private String copyright;

  @ApiModelProperty(
      notes =
          "The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.",
      position = 4,
      example = "Data provided by Marvel. © 2020 MARVEL")
  private String attributionText;

  @ApiModelProperty(
      notes =
          "An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.",
      position = 5,
      example = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
  private String attributionHTML;

  @ApiModelProperty(notes = "The results returned by the call.", position = 6)
  private StoryDataContainerDTO data;

  @ApiModelProperty(
      notes = "A digest value of the content returned by the call.",
      position = 7,
      example = "5375224cd1105dc965f8ae030b561a3ca5862344")
  private String etag;
}
