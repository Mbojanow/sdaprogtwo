package pl.sdacademy.prog.day6.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

public class StrategyDemoMain {

  public static void main(String[] args) {
    final TextModificationStrategyProvider provider = new TextModificationStrategyProvider();
    final FileContentModificationService service = new FileContentModificationService(provider);
    service.processFile(args);
  }

  // przed java7
//    BufferedReader bufferedReader = null;
//    try {
//      bufferedReader = new BufferedReader(new FileReader(fileWithText));
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } finally {
//      if (bufferedReader != null) {
//        try {
//          bufferedReader.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    }
}
