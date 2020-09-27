package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.impl.EventSummaryConverter;
import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EventSummaryConverterTest {

  @InjectMocks private EventSummaryConverter converter;

  @Test
  public void testConvertNullProperties() {
    List<EventSummary> events = new ArrayList<>();
    events.add(EventSummary.builder().build());

    EventListDTO converted = converter.convert(events);

    Assertions.assertNotNull(converted);
  }

  @Test
  public void testConvertNullObject() {
    EventListDTO converted = converter.convert(null);

    Assertions.assertNull(converted);
  }
}
