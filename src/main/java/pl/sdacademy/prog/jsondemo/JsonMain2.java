package pl.sdacademy.prog.jsondemo;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMain2 {

  public static void main(String[] args) throws JsonProcessingException {
    final ObjectMapper objectMapper = new ObjectMapper();

    final ObjectX objectX = new ObjectX(null, 183, List.of());
    final String output = objectMapper.writeValueAsString(objectX);
    System.out.println(output);
  }
}
