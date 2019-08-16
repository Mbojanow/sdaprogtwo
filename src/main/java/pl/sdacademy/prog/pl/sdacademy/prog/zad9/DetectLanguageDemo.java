package pl.sdacademy.prog.pl.sdacademy.prog.zad9;

import java.io.IOException;
import java.util.List;

public class DetectLanguageDemo {

    public static void main(String[] args) throws IOException {
        final TxtDirFilesReader txtDirFilesReader = new TxtDirFilesReader();
        final List<String> output = txtDirFilesReader.readAllFilesContent(args[0]);
        final DetectLanguageNativeService detectLanguageService = new DetectLanguageNativeService();

        detectLanguageService.processTexts(output);
    }
}
