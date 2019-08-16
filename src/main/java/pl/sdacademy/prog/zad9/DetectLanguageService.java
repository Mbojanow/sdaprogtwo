package pl.sdacademy.prog.zad9;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class DetectLanguageService {

    static {
        DetectLanguage.apiKey = "c0fb0670d45175685704d53a3eb63dfa";
    }

    public void processTexts(final List<String> textsToDetect) {
        textsToDetect.forEach(this::processText);
    }

    private void processText(final String textToDetect) {
        try {
            final List<Result> results = DetectLanguage.detect(textToDetect);
            printReadableResults(results, textToDetect);

        } catch (final APIError apiError) {
            throw new DetectLanguageException("Detect Language APIError occured", apiError);
        }
    }

    private void printReadableResults(final List<Result> results, final String text) {
        System.out.println("------------------");
        System.out.println(text);
        System.out.println("is written in:");
        results.forEach(result -> System.out.println(result.language + " and I am " + (result.isReliable ? "sure" : "not sure") + " about it"));
        System.out.println("------------------");
    }
}
