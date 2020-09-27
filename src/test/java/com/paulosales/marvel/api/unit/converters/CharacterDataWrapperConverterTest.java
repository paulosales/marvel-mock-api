package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.converters.impl.CharacterDataWrapperConverter;
import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
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
public class CharacterDataWrapperConverterTest {

  @InjectMocks private CharacterDataWrapperConverter converter;

  @Mock private Converter<List<ComicSummary>, ComicListDTO> comicConverter;

  @Mock private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Mock private Converter<List<SeriesSummary>, SeriesListDTO> serieConverter;

  @Mock private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Test
  public void testConvertNullProperties() {
    List<Character> characters = new ArrayList<>();
    characters.add(Character.builder().build());

    CharacterDataWrapperDTO converted = converter.convert(characters);

    Assertions.assertNotNull(converted);
  }
}
