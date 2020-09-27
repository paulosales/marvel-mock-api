package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterDTO;
import com.paulosales.marvel.api.rest.dto.CharacterDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CharacterDataWrapperConverter
    implements Converter<List<Character>, CharacterDataWrapperDTO> {

  @Autowired
  @Qualifier("comicSummaryConverter")
  private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Autowired
  @Qualifier("storySummaryConverter")
  private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Autowired
  @Qualifier("seriesSummaryConverter")
  private Converter<List<SeriesSummary>, SeriesListDTO> serieConverter;

  @Autowired
  @Qualifier("eventSummaryConverter")
  private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Override
  public CharacterDataWrapperDTO convert(List<Character> characters) {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<CharacterDTO> charactersDto =
        characters.stream()
            .map(
                character -> {
                  CharacterDTO characterDTO = mapper.map(character, CharacterDTO.class);
                  characterDTO.setComics(comicConverter.convert(character.getComics()));
                  characterDTO.setStories(storyConverter.convert(character.getStories()));
                  characterDTO.setSeries(serieConverter.convert(character.getSeries()));
                  characterDTO.setEvents(eventConverter.convert(character.getEvents()));
                  return characterDTO;
                })
            .collect(Collectors.toList());

    return CharacterDataWrapperDTO.builder()
        .code(200)
        .status("Ok")
        .copyright("© 2020 MARVEL")
        .attributionText("Data provided by Marvel. © 2020 MARVEL")
        .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
        .data(CharacterDataContainerDTO.builder().results(charactersDto).build())
        .build();
  }
}
