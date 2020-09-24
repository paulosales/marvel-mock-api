package com.paulosales.marvel.api.rest.resources;

import com.paulosales.marvel.api.rest.dto.CharacterDataWrapperDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("characters")
@Api(tags = "character")
public class CharacterResource {
  @GetMapping
  @ApiOperation(nickname = "getCharacters", value = "Retrieves the characters list.")
  @ApiResponses({
    @ApiResponse(
        code = 409,
        message =
            "Limit greater than 100. | Limit invalid or below 1. | Invalid or unrecognized parameter. | Empty parameter. | Invalid or unrecognized ordering parameter. | Too many values sent to a multi-value list filter. | Invalid value passed to filter.")
  })
  public ResponseEntity<CharacterDataWrapperDTO> getCharacters() {
    log.debug("Querying characters");
    return ResponseEntity.ok().build();
  }
}
