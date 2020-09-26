package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Image")
public class ImageDTO {

  @ApiModelProperty(
      notes = "The directory path of to the image.",
      position = 1,
      example = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
  private String path;

  @ApiModelProperty(notes = "The file extension for the image.", position = 2, example = "jpg")
  private String extension;
}
