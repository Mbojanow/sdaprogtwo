package pl.sdacademy.prog.zad12;

public class EncryptionDemo {

  ///Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/test1
  // /Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/test2
  // 1
  // 123

  // /Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/test2
  // /Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/test3
  // 2
  // 123
  public static void main(String[] args) throws Exception {
    final AESEncryptionService aesEncryptionService = new AESEncryptionService();
    aesEncryptionService.execute(args[0], args[1], Integer.parseInt(args[2]),
        Long.parseLong(args[3]));
  }
}
