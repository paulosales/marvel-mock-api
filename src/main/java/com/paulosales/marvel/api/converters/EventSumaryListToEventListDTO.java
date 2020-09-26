package com.paulosales.marvel.api.converters;

import com.paulosales.marvel.api.data.models.EventSummary;
import com.paulosales.marvel.api.rest.dto.EventListDTO;
import com.paulosales.marvel.api.rest.dto.EventSummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class EventSumaryListToEventListDTO implements Converter<List<EventSummary>, EventListDTO> {

  @Override
  public EventListDTO convert(List<EventSummary> eventSummaryList) {
    if (eventSummaryList == null) return null;

    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<EventSummaryDTO> eventSumaryListDTO =
        eventSummaryList.stream()
            .map(eventSummary -> mapper.map(eventSummary, EventSummaryDTO.class))
            .collect(Collectors.toList());
    return EventListDTO.builder().items(eventSumaryListDTO).build();
  }
}
