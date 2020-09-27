package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import com.paulosales.marvel.api.rest.dto.StoryDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StoryDataWrapperConverter implements Converter<List<Story>, StoryDataWrapperDTO> {

  @Autowired
  @Qualifier("comicSummaryConverter")
  private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Autowired
  @Qualifier("seriesSummaryConverter")
  private Converter<List<SeriesSummary>, SeriesListDTO> seriesConverter;

  @Autowired
  @Qualifier("characterSummaryConverter")
  private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Autowired
  @Qualifier("eventSummaryConverter")
  private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Override
  public StoryDataWrapperDTO convert(List<Story> stories) {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<StoryDTO> storiesDto =
        stories.stream()
            .map(
                story -> {
                  StoryDTO storiesDTO = mapper.map(story, StoryDTO.class);
                  storiesDTO.setComics(comicConverter.convert(story.getComics()));
                  storiesDTO.setSeries(seriesConverter.convert(story.getSeries()));
                  storiesDTO.setCharacters(characterConverter.convert(story.getCharacters()));
                  storiesDTO.setEvents(eventConverter.convert(story.getEvents()));
                  return storiesDTO;
                })
            .collect(Collectors.toList());

    return StoryDataWrapperDTO.builder()
        .code(200)
        .status("Ok")
        .copyright("© 2020 MARVEL")
        .attributionText("Data provided by Marvel. © 2020 MARVEL")
        .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
        .data(StoryDataContainerDTO.builder().results(storiesDto).build())
        .build();
  }
}
