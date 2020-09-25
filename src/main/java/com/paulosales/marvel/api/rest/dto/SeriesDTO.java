package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@ApiModel(value = "Series")
@Data
public class SeriesDTO {

  @ApiModelProperty(notes = "The unique ID of the series resource.", position = 1)
  private Long id;

  @ApiModelProperty(notes = "The canonical title of the series.", position = 2)
  private String title;

  @ApiModelProperty(notes = "A description of the series.", position = 3)
  private String description;

  @ApiModelProperty(notes = "The canonical URL identifier for this resource.", position = 4)
  private String resourceURI;

  @ApiModelProperty(notes = ": A set of public web site URLs for the resource.", position = 5)
  private List<UrlDTO> urls;

  @ApiModelProperty(notes = "The first year of publication for the series.", position = 6)
  private Integer startYear;

  @ApiModelProperty(
      notes =
          "The last year of publication for the series (conventionally, 2099 for ongoing series) .",
      position = 7)
  private Integer endYear;

  @ApiModelProperty(notes = "The age-appropriateness rating for the series.", position = 8)
  private String rating;

  @ApiModelProperty(notes = "The date the resource was most recently modified.", position = 9)
  private Date modified;

  @ApiModelProperty(notes = "The representative image for this series.", position = 10)
  private ImageDTO thumbnail;

  @ApiModelProperty(notes = "A resource list containing comics in this series.", position = 11)
  private ComicListDTO comics;

  @ApiModelProperty(
      notes = "A resource list containing stories which occur in comics in this series.",
      position = 12)
  private StoryListDTO stories;

  @ApiModelProperty(
      notes = "A resource list containing events which take place in comics in this series.",
      position = 13)
  private EventListDTO events;

  @ApiModelProperty(
      notes = "A resource list containing characters which appear in comics in this series.",
      position = 14)
  private CharacterListDTO characters;

  @ApiModelProperty(
      notes = "A resource list of creators whose work appears in comics in this series.",
      position = 15)
  private CreatorListDTO creators;

  @ApiModelProperty(
      notes = "A summary representation of the series which follows this series.",
      position = 16)
  private SeriesSummaryDTO next;

  @ApiModelProperty(
      notes = "A summary representation of the series which preceded this series.",
      position = 17)
  private SeriesSummaryDTO previous;
}
