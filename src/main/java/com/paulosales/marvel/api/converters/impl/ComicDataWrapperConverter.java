package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesSummaryDTO;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComicDataWrapperConverter implements Converter<List<Comic>, ComicDataWrapperDTO> {

  @Autowired
  @Qualifier("characterSummaryConverter")
  private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Autowired
  @Qualifier("storySummaryConverter")
  private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Autowired
  @Qualifier("eventSummaryConverter")
  private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Override
  public ComicDataWrapperDTO convert(List<Comic> comics) {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<ComicDTO> comicsDto =
        comics.stream()
            .map(
                comic -> {
                  ComicDTO comicDTO = mapper.map(comic, ComicDTO.class);
                  comicDTO.setCharacters(characterConverter.convert(comic.getCharacters()));
                  comicDTO.setStories(storyConverter.convert(comic.getStories()));
                  comicDTO.setEvents(eventConverter.convert(comic.getEvents()));
                  if (comic.getSeries() != null) {
                    comicDTO.setSeries(mapper.map(comic.getSeries(), SeriesSummaryDTO.class));
                  }
                  return comicDTO;
                })
            .collect(Collectors.toList());

    return ComicDataWrapperDTO.builder()
        .code(200)
        .status("Ok")
        .copyright("© 2020 MARVEL")
        .attributionText("Data provided by Marvel. © 2020 MARVEL")
        .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
        .data(ComicDataContainerDTO.builder().results(comicsDto).build())
        .build();
  }
}
