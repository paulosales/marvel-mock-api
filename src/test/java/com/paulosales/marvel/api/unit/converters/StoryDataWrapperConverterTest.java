package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.converters.impl.StoryDataWrapperConverter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class StoryDataWrapperConverterTest {

  @InjectMocks private StoryDataWrapperConverter converter;

  @Mock private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Mock private Converter<List<SeriesSummary>, SeriesListDTO> seriesConverter;

  @Mock private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Mock private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Test
  public void testConvertNullProperties() {
    List<Story> stories = new ArrayList<>();
    stories.add(Story.builder().build());

    StoryDataWrapperDTO converted = converter.convert(stories);

    Assertions.assertNotNull(converted);
  }
}
