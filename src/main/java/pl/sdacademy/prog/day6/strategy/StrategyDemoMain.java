package pl.sdacademy.prog.day6.strategy;

import static java.util.Objects.nonNull;

public class StrategyDemoMain {

  public static void main(String[] args) {
    final TextModificationStrategyProvider provider = new TextModificationStrategyProvider();
    final CustomCommandLineParser parser = new CustomCommandLineParser();
    final FileContentModificationService service = new FileContentModificationService(provider, parser);
    try {
      service.processFile(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      if (nonNull(e.getCause())) {
        System.out.println(e.getCause().getMessage());
      }
    }
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
