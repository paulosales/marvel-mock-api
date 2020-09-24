package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Url")
public class UrlDTO {

  @ApiModelProperty(notes = "A text identifier for the URL.", position = 1, example = "detail")
  private String type;

  @ApiModelProperty(
      notes = "A full URL (including scheme, domain, and path).",
      position = 2,
      example =
          "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985")
  private String url;
}
