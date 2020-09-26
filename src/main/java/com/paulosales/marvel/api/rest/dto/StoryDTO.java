package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "Story")
@Data
public class StoryDTO {

  @ApiModelProperty(notes = "The unique ID of the story resource.", position = 1)
  private String id;

  @ApiModelProperty(notes = "The story title.", position = 2)
  private String title;

  @ApiModelProperty(notes = "A short description of the story.", position = 3)
  private String description;

  @ApiModelProperty(notes = "The canonical URL identifier for this resource. ", position = 4)
  private String resourceURI;

  @ApiModelProperty(notes = "The story type e.g. interior story, cover, text story.", position = 5)
  private String type;

  @ApiModelProperty(notes = "The date the resource was most recently modified.", position = 6)
  private Date modified;

  @ApiModelProperty(notes = "The representative image for this story.", position = 7)
  private ImageDTO thumbnail;

  @ApiModelProperty(
      notes = "A resource list containing comics in which this story takes place.",
      position = 8)
  private ComicListDTO comics;

  @ApiModelProperty(
      notes = "A resource list containing series in which this story appears.",
      position = 9)
  private SeriesListDTO series;

  @ApiModelProperty(
      notes = "A resource list of the events in which this story appears.",
      position = 10)
  private EventListDTO events;

  @ApiModelProperty(
      notes = "A resource list of characters which appear in this story.",
      position = 11)
  private CharacterListDTO characters;

  @ApiModelProperty(notes = "A resource list of creators who worked on this story.", position = 12)
  private CreatorListDTO creators;

  @ApiModelProperty(
      notes = "A summary representation of the issue in which this story was originally published.",
      position = 13)
  private ComicSummaryDTO originalissue;
}
