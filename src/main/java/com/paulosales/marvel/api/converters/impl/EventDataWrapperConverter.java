package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventDTO;
import com.paulosales.marvel.api.rest.dto.EventDataContainerDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
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
public class EventDataWrapperConverter implements Converter<List<Event>, EventDataWrapperDTO> {

  @Autowired
  @Qualifier("characterSummaryConverter")
  private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Autowired
  @Qualifier("storySummaryConverter")
  private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Autowired
  @Qualifier("eventSummaryConverter")
  private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Autowired
  @Qualifier("comicSummaryConverter")
  private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Autowired
  @Qualifier("seriesSummaryConverter")
  private Converter<List<SeriesSummary>, SeriesListDTO> seriesConverter;

  @Override
  public EventDataWrapperDTO convert(List<Event> events) {
    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<EventDTO> eventDto =
        events.stream()
            .map(
                event -> {
                  EventDTO eventDTO = mapper.map(event, EventDTO.class);
                  eventDTO.setCharacters(characterConverter.convert(event.getCharacters()));
                  eventDTO.setStories(storyConverter.convert(event.getStories()));
                  eventDTO.setComics(comicConverter.convert(event.getComics()));
                  eventDTO.setSeries(seriesConverter.convert(event.getSeries()));
                  return eventDTO;
                })
            .collect(Collectors.toList());

    return EventDataWrapperDTO.builder()
        .code(200)
        .status("Ok")
        .copyright("© 2020 MARVEL")
        .attributionText("Data provided by Marvel. © 2020 MARVEL")
        .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>")
        .data(EventDataContainerDTO.builder().results(eventDto).build())
        .build();
  }
}
