package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.converters.impl.SeriesDataWrapperConverter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
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
public class SeriesDataWrapperConverterTest {

  @InjectMocks private SeriesDataWrapperConverter converter;

  @Mock private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Mock private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Mock private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Mock private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Test
  public void testConvertNullProperties() {
    List<Series> series = new ArrayList<>();
    series.add(Series.builder().build());

    SeriesDataWrapperDTO converted = converter.convert(series);

    Assertions.assertNotNull(converted);
  }
}
