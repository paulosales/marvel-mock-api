package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TextObject")
public class TextObjectDTO {

  @ApiModelProperty(
      notes = "The canonical type of the text object (e.g. solicit text, preview text, etc.).",
      position = 1,
      example = "issue_preview_text")
  private String type;

  @ApiModelProperty(
      notes = "The IETF language tag denoting the language the text object is written in.",
      position = 2,
      example = "en-us")
  private String language;

  @ApiModelProperty(
      notes = "The text.",
      position = 3,
      example =
          "Now that the Kill Krew knows Skrullowjacket's master plan, can they stop the true mission of the Fifty State Initiative? Plus, Thor Girl vs. Ultra Girl! One is more than she appears to be and the other's a Skrull!")
  private String text;
}
