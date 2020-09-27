package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesSummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SeriesSummaryConverter implements Converter<List<SeriesSummary>, SeriesListDTO> {

  @Override
  public SeriesListDTO convert(List<SeriesSummary> serieSummaryList) {
    if (serieSummaryList == null) return null;

    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<SeriesSummaryDTO> serieSumaryListDTO =
        serieSummaryList.stream()
            .map(serieSummary -> mapper.map(serieSummary, SeriesSummaryDTO.class))
            .collect(Collectors.toList());
    return SeriesListDTO.builder().items(serieSumaryListDTO).build();
  }
}
