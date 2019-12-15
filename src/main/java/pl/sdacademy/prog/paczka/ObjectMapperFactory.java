package pl.sdacademy.prog.paczka;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

  public ObjectMapper createCommonObjectMapper() {
    return new ObjectMapper();
  }
}
