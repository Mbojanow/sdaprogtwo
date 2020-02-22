package pl.sdacademy.prog.strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import pl.sdacademy.prog.streams.SdaException;

public class FileContentReader {

  public String readContent(final String path) {
    try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
      return bufferedReader
          .lines()
          .collect(Collectors.joining("\n"));
    } catch (IOException e) {
      throw new SdaException("Content cannot be read", e);
    }
  }
}
