package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.converters.impl.EventDataWrapperConverter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EventDataWrapperConverterTest {

  @InjectMocks private EventDataWrapperConverter converter;

  @Mock private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Mock private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Mock private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Mock private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Mock private Converter<List<SeriesSummary>, SeriesListDTO> seriesConverter;

  @Test
  public void testConvertNullProperties() {
    List<Event> events = new ArrayList<>();
    events.add(Event.builder().build());

    EventDataWrapperDTO converted = converter.convert(events);

    Assertions.assertNotNull(converted);
  }
}
