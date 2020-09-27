package com.paulosales.marvel.api.converters.impl;

import com.paulosales.marvel.api.converters.Converter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import com.paulosales.marvel.api.rest.dto.CharacterSummaryDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CharacterSummaryConverter
    implements Converter<List<CharacterSummary>, CharacterListDTO> {

  @Override
  public CharacterListDTO convert(List<CharacterSummary> characterSummaryList) {
    if (characterSummaryList == null) return null;

    ModelMapper mapper = new ModelMapper();
    mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    List<CharacterSummaryDTO> characterSummaryListDTO =
        characterSummaryList.stream()
            .map(characterSummary -> mapper.map(characterSummary, CharacterSummaryDTO.class))
            .collect(Collectors.toList());
    return CharacterListDTO.builder().items(characterSummaryListDTO).build();
  }
}
