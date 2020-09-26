package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "Character")
public class CharacterDTO {

  @ApiModelProperty(
      notes = "The unique ID of the character resource.",
      position = 1,
      example = "5f6e2f447ab01f6a397f2748")
  private String id;

  @ApiModelProperty(notes = "The name of the character.", position = 2, example = "3-D Man")
  private String name;

  @ApiModelProperty(
      notes = " A short bio or description of the character.",
      position = 3,
      example = "")
  private String description;

  @ApiModelProperty(
      notes = "The date the resource was most recently modified.",
      position = 4,
      example = "2014-04-29T14:18:17-0400")
  private Date modified;

  @ApiModelProperty(
      notes = "The canonical URL identifier for this resource.",
      position = 5,
      example = "http://gateway.marvel.com/v1/public/characters/1011334")
  private String resourceURI;

  @ApiModelProperty(
      notes =
          "A set of public web site URLs for the resThe representative image for this characterource.",
      position = 6)
  private List<UrlDTO> urls;

  @ApiModelProperty(notes = "The representative image for this character.", position = 7)
  private ImageDTO thumbnail;

  @ApiModelProperty(
      notes = "A resource list containing comics which feature this character.",
      position = 8)
  private ComicListDTO comics;

  @ApiModelProperty(
      notes = "A resource list of stories in which this character appears.",
      position = 9)
  private StoryListDTO stories;

  @ApiModelProperty(
      notes = " A resource list of events in which this character appears.",
      position = 10)
  private EventListDTO events;

  @ApiModelProperty(
      notes = " A resource list of series in which this character appears.",
      position = 11)
  private SeriesListDTO series;
}
