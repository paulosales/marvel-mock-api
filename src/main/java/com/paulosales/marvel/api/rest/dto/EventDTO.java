package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@ApiModel(value = "Event")
public class EventDTO {

  @ApiModelProperty(notes = "The unique ID of the event resource.", position = 1)
  private Integer id;

  @ApiModelProperty(notes = "The title of the event.", position = 2)
  private String title;

  @ApiModelProperty(notes = "A description of the event.", position = 3)
  private String description;

  @ApiModelProperty(notes = "The canonical URL identifier for this resource.", position = 4)
  private String resourceURI;

  @ApiModelProperty(notes = "A set of public web site URLs for the event.", position = 5)
  private List<UrlDTO> urls;

  @ApiModelProperty(notes = "The date the resource was most recently modified.", position = 6)
  private Date modified;

  @ApiModelProperty(
      notes = "The date of publication of the first issue in this event.",
      position = 7)
  private Date start;

  @ApiModelProperty(
      notes = "The date of publication of the last issue in this event.",
      position = 8)
  private Date end;

  @ApiModelProperty(notes = "The representative image for this event.", position = 9)
  private ImageDTO thumbnail;

  @ApiModelProperty(notes = "A resource list containing the comics in this event.", position = 10)
  private ComicListDTO comics;

  @ApiModelProperty(notes = "A resource list containing the stories in this event.", position = 11)
  private StoryListDTO stories;

  @ApiModelProperty(notes = "A resource list containing the series in this event.", position = 12)
  private SeriesListDTO series;

  @ApiModelProperty(
      notes = "A resource list containing the characters which appear in this event.",
      position = 13)
  private CharacterListDTO characters;

  @ApiModelProperty(
      notes = "A resource list containing creators whose work appears in this event.",
      position = 14)
  private CreatorListDTO creators;

  @ApiModelProperty(
      notes = "A summary representation of the event which follows this event.",
      position = 15)
  private EventSummaryDTO next;

  @ApiModelProperty(
      notes = "A summary representation of the event which preceded this event.",
      position = 16)
  private EventSummaryDTO previous;
}
