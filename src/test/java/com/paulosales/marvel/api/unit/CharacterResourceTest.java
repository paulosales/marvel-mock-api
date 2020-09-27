package com.paulosales.marvel.api.unit;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.Character;
import com.paulosales.marvel.api.data.models.Comic;
import com.paulosales.marvel.api.data.models.Event;
import com.paulosales.marvel.api.data.models.Series;
import com.paulosales.marvel.api.data.models.Story;
import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.ComicDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.EventDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.SeriesDataWrapperDTO;
import com.paulosales.marvel.api.rest.dto.StoryDataWrapperDTO;
import com.paulosales.marvel.api.rest.resources.CharacterResource;
import com.paulosales.marvel.api.service.CharacterService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CharacterResourceTest {

  @InjectMocks private CharacterResource characterResource;

  @Mock private CharacterService characterService;

  @Mock private Converter<List<Character>, CharacterDataWrapperDTO> characterConverter;

  @Mock private Converter<List<Comic>, ComicDataWrapperDTO> comicConverter;

  @Mock private Converter<List<Event>, EventDataWrapperDTO> eventConverter;

  @Mock private Converter<List<Series>, SeriesDataWrapperDTO> seriesConverter;

  @Mock private Converter<List<Story>, StoryDataWrapperDTO> storyConverter;

  @Test
  public void testGetCharacters() {

    ResponseEntity<CharacterDataWrapperDTO> response = characterResource.getCharacters();

    Assertions.assertNotNull(response);
  }
}
