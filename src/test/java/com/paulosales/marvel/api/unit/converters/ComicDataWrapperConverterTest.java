package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.converters.impl.ComicDataWrapperConverter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
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
public class ComicDataWrapperConverterTest {
  @InjectMocks private ComicDataWrapperConverter converter;

  @Mock private Converter<List<StorySummary>, StoryListDTO> storyConverter;

  @Mock private Converter<List<CharacterSummary>, CharacterListDTO> characterConverter;

  @Mock private Converter<List<EventSummary>, EventListDTO> eventConverter;

  @Test
  public void testConvertNullProperties() {
    List<Comic> comics = new ArrayList<>();
    comics.add(Comic.builder().build());

    ComicDataWrapperDTO converted = converter.convert(comics);

    Assertions.assertNotNull(converted);
  }
}
