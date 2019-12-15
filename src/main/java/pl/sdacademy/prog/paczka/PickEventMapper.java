package pl.sdacademy.prog.paczka;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PickEventMapper {
  private final ObjectMapperFactory objectMapperFactory;

  public PickEventMapper(final ObjectMapperFactory objectMapperFactory) {
    this.objectMapperFactory = objectMapperFactory;
  }

  public Optional<PickEvent> toPickEvent(final List<Byte> eventAsBytes) {
    final ObjectMapper commonObjectMapper = objectMapperFactory.createCommonObjectMapper();
    try {
      return Optional.of(commonObjectMapper
          .readValue(ArrayUtils.toPrimitive(eventAsBytes.toArray(Byte[]::new)),
          PickEvent.class));
    } catch (final IOException exp) {
      return Optional.empty();
    }
  }
}
