package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.impl.StorySummaryConverter;
import com.paulosales.marvel.api.data.models.StorySummary;
import com.paulosales.marvel.api.rest.dto.StoryListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class StorySummaryConverterTest {

  @InjectMocks private StorySummaryConverter converter;

  @Test
  public void testConvertNullProperties() {
    List<StorySummary> stories = new ArrayList<>();
    stories.add(StorySummary.builder().build());

    StoryListDTO converted = converter.convert(stories);

    Assertions.assertNotNull(converted);
  }

  @Test
  public void testConvertNullObject() {
    StoryListDTO converted = converter.convert(null);

    Assertions.assertNull(converted);
  }
}
