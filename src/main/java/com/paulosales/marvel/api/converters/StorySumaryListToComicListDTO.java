package com.paulosales.marvel.api.converters;

import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import com.paulosales.marvel.api.rest.dto.StorySummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class StorySumaryListToComicListDTO implements Converter<List<StorySummary>, StoryListDTO> {

  @Override
  public StoryListDTO convert(List<StorySummary> storySummaryList) {
    if (storySummaryList == null) return null;

    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<StorySummaryDTO> storySumaryListDTO =
        storySummaryList.stream()
            .map(storySummary -> mapper.map(storySummary, StorySummaryDTO.class))
            .collect(Collectors.toList());
    return StoryListDTO.builder().items(storySumaryListDTO).build();
  }
}
