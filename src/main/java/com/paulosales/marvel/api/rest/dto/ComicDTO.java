package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@ApiModel("Commic")
public class ComicDTO {

  @ApiModelProperty(
      notes = "The unique ID of the comic resource.",
      position = 1,
      example = "5f6e2f447ab01f6a397f2748")
  private String id;

  @ApiModelProperty(
      notes =
          "The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.",
      position = 2,
      example = "10949")
  private Long digitalId;

  @ApiModelProperty(
      notes = "The canonical title of the comic.",
      position = 3,
      example = "Avengers: The Initiative (2007) #19")
  private String title;

  @ApiModelProperty(
      notes = "The number of the issue in the series (will generally be 0 for collection formats).",
      position = 4,
      example = "19")
  private Double issueNumber;

  @ApiModelProperty(
      notes =
          "If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant.",
      position = 5,
      example = "")
  private String variantDescription;

  @ApiModelProperty(
      notes = "The preferred description of the comic.",
      position = 6,
      example =
          "Join 3-D MAN, CLOUD 9, KOMODO, HARDBALL, and heroes around America in the battle that will decide the fate of the planet and the future of the Initiative program. Will the Kill Krew Army win the day?")
  private String description;

  @ApiModelProperty(
      notes = "The date the resource was most recently modified.",
      position = 7,
      example = "2015-10-27T16:38:23-0400")
  private Date modified;

  @ApiModelProperty(
      notes = "The ISBN for the comic (generally only populated for collection formats).",
      position = 8,
      example = "")
  private String isbn;

  @ApiModelProperty(
      notes =
          "The UPC barcode number for the comic (generally only populated for periodical formats).",
      position = 9,
      example = "5960606084-01911")
  private String upc;

  @ApiModelProperty(notes = "The Diamond code for the comic.", position = 10, example = "SEP082362")
  private String diamondCode;

  @ApiModelProperty(notes = "The EAN barcode for the comic.", position = 11, example = "")
  private String ean;

  @ApiModelProperty(notes = "The ISSN barcode for the comic.", position = 12, example = "")
  private String issn;

  @ApiModelProperty(
      notes = "The publication format of the comic e.g. comic, hardcover, trade paperback.",
      position = 13,
      example = "Comic")
  private String format;

  @ApiModelProperty(
      notes = "The number of story pages in the comic.",
      position = 14,
      example = "32")
  private Integer pageCount;

  @ApiModelProperty(notes = "A set of descriptive text blurbs for the comic.", position = 15)
  private List<TextObjectDTO> textObjects;

  @ApiModelProperty(
      notes = "The canonical URL identifier for this resource.",
      position = 16,
      example = "http://gateway.marvel.com/v1/public/comics/22506")
  private String resourceURI;

  @ApiModelProperty(notes = "A set of public web site URLs for the resource.", position = 17)
  private List<UrlDTO> urls;

  @ApiModelProperty(
      notes = "A summary representation of the series to which this comic belongs.",
      position = 18)
  private SeriesSummaryDTO series;

  @ApiModelProperty(
      notes =
          "A list of variant issues for this comic (includes the \"original\" issue if the current issue is a variant).",
      position = 19)
  private List<ComicSummaryDTO> variants;

  @ApiModelProperty(
      notes =
          "A list of collections which include this comic (will generally be empty if the comic's format is a collection).",
      position = 20)
  private List<ComicSummaryDTO> collections;

  @ApiModelProperty(
      notes =
          "A list of issues collected in this comic (will generally be empty for periodical formats such as \"comic\" or \"magazine\").",
      position = 21)
  private List<ComicSummaryDTO> collectedIssues;

  @ApiModelProperty(notes = "A list of key dates for this comic.", position = 22)
  private List<ComicDateDTO> dates;

  @ApiModelProperty(notes = "A list of prices for this comic.", position = 23)
  private List<ComicPriceDTO> prices;

  @ApiModelProperty(notes = "The representative image for this comic.", position = 24)
  private ImageDTO thumbnail;

  @ApiModelProperty(
      notes = "A list of promotional images associated with this comic.",
      position = 25)
  private List<ImageDTO> images;

  @ApiModelProperty(
      notes = "A resource list containing the creators associated with this comic.",
      position = 26)
  private CreatorListDTO creators;

  @ApiModelProperty(
      notes = "A resource list containing the characters which appear in this comic.",
      position = 27)
  private CharacterListDTO characters;

  @ApiModelProperty(
      notes = "A resource list containing the stories which appear in this comic.",
      position = 28)
  private StoryListDTO stories;

  @ApiModelProperty(
      notes = "A resource list containing the events in which this comic appears",
      position = 29)
  private EventListDTO events;
}
