package pl.sdacademy.prog.strA;

import java.io.IOException;

public class FilesStreamsDemo {

    public static void main(String[] args) throws IOException {
        final String path = args[0];

        final AccountDataService accountDataService = new AccountDataService();

        accountDataService.readFromFile(path).forEach(System.out::println);
    }
}
