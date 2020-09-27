package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.impl.ComicSummaryConverter;
import com.paulosales.marvel.api.data.models.ComicSummary;
import com.paulosales.marvel.api.rest.dto.ComicListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ComicSummaryConverterTest {

  @InjectMocks private ComicSummaryConverter converter;

  @Test
  public void testConvertNullProperties() {
    List<ComicSummary> comics = new ArrayList<>();
    comics.add(ComicSummary.builder().build());

    ComicListDTO converted = converter.convert(comics);

    Assertions.assertNotNull(converted);
  }
}
