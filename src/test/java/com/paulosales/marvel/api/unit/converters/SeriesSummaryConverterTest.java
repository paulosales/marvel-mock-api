package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.impl.SeriesSummaryConverter;
import com.paulosales.marvel.api.data.models.SeriesSummary;
import com.paulosales.marvel.api.rest.dto.SeriesListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SeriesSummaryConverterTest {

  @InjectMocks private SeriesSummaryConverter converter;

  @Test
  public void testConvertNullProperties() {
    List<SeriesSummary> series = new ArrayList<>();
    series.add(SeriesSummary.builder().build());

    SeriesListDTO converted = converter.convert(series);

    Assertions.assertNotNull(converted);
  }
}
