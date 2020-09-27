package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.ComicSummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ComicSummaryConverter implements Converter<List<ComicSummary>, ComicListDTO> {

  @Override
  public ComicListDTO convert(List<ComicSummary> comicSummaryList) {
    if (comicSummaryList == null) return null;

    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<ComicSummaryDTO> comicSumaryListDTO =
        comicSummaryList.stream()
            .map(comicSummary -> mapper.map(comicSummary, ComicSummaryDTO.class))
            .collect(Collectors.toList());
    return ComicListDTO.builder().items(comicSumaryListDTO).build();
  }
}
