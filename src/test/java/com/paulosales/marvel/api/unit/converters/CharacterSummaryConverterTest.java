package com.paulosales.marvel.api.unit.converters;

import com.paulosales.marvel.api.converters.impl.CharacterSummaryConverter;
import com.paulosales.marvel.api.data.models.CharacterSummary;
import com.paulosales.marvel.api.rest.dto.CharacterListDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CharacterSummaryConverterTest {

  @InjectMocks private CharacterSummaryConverter converter;

  @Test
  public void testConvertNullProperties() {
    List<CharacterSummary> characterSummaryList = new ArrayList<>();
    characterSummaryList.add(CharacterSummary.builder().build());

    CharacterListDTO converted = converter.convert(characterSummaryList);

    Assertions.assertNotNull(converted);
  }

  @Test
  public void testConvertNullObject() {
    CharacterListDTO converted = converter.convert(null);

    Assertions.assertNull(converted);
  }
}
