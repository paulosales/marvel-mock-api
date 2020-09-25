package com.paulosales.marvel.api.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ComicPrice")
public class ComicPriceDTO {
  @ApiModelProperty(
      notes = "A description of the price (e.g. print price, digital price).",
      position = 1,
      example = "printPrice")
  private String type;

  @ApiModelProperty(notes = "The price (all prices in USD)", position = 2, example = "2.99")
  private Double price;
}
