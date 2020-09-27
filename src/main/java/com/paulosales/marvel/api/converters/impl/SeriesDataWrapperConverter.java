package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SeriesDataWrapperConverter implements Converter<List<Series>, SeriesDataWrapperDTO> {

  @Autowired
  @Qualifier("comicSummaryConverter")
  private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Autowired
  @Qualifier("storySummaryConverter")
  private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Autowired
  @Qualifier("characterSummaryConverter")
  private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Autowired
  @Qualifier("eventSummaryConverter")
  private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Override
  public SeriesDataWrapperDTO convert(List<Series> series) {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<SeriesDTO> seriesDto =
        series.stream()
            .map(
                serie -> {
                  SeriesDTO seriesDTO = mapper.map(serie, SeriesDTO.class);
                  seriesDTO.setComics(comicConverter.convert(serie.getComics()));
                  seriesDTO.setStories(storyConverter.convert(serie.getStories()));
                  seriesDTO.setCharacters(characterConverter.convert(serie.getCharacters()));
                  seriesDTO.setEvents(eventConverter.convert(serie.getEvents()));
                  return seriesDTO;
                })
            .collect(Collectors.toList());

    return SeriesDataWrapperDTO.builder()
        .code(200)
        .status("Ok")
        .copyright("© 2020 MARVEL")
        .attributionText("Data provided by Marvel. © 2020 MARVEL")
        .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
        .data(SeriesDataContainerDTO.builder().results(seriesDto).build())
        .build();
  }
}
