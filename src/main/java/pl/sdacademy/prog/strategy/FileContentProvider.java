package pl.sdacademy.prog.strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import pl.sdacademy.prog.stra.GenericException;

public class FileContentProvider {

  public String readContent(final String path) {
    try (final BufferedReader bufferedReader
             = new BufferedReader(new FileReader(new File(path)))) {
      return bufferedReader.lines()
          .collect(Collectors.joining("\n"));
    } catch (final IOException exp) {
      throw new GenericException("Cannot read file content", exp);
    }
  }
}
