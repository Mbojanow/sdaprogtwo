package pl.sdacademy.prog.pl.sdacademy.prog.zad9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
public class DetectLanguageNativeService {

    private static final String API_KEY = "c0fb0670d45175685704d53a3eb63dfa";
    private static final String DETECT_LANGUAGE_BASE_URL = "https://ws.detectlanguage.com";
    private static final String BEARER = "Bearer";
    private static final String AUTHORIZATION = "Authorization";
    private final RestTemplate restTemplate;

    public DetectLanguageNativeService() {
        restTemplate = new RestTemplateBuilder()
                .rootUri(DETECT_LANGUAGE_BASE_URL)
                .build();
    }

    public void processTexts(final List<String> textsToDetect) {
        textsToDetect.forEach(this::processText);
    }

    private void processText(final String textToDetect) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, BEARER + " " + API_KEY);
        headers.add(HttpHeaders.ACCEPT, APPLICATION_JSON.toString());
        final HttpEntity<Object> request = new HttpEntity<>(headers);
        try {
            final ResponseEntity<LanguageData> response = restTemplate.postForEntity("/0.2/detect?q=" + textToDetect, request, LanguageData.class);
            response.getBody().getDetections().getDetections().forEach(detection -> System.out.println("Language is " + detection.getLanguage() + " and is " + detection.isReliable()));
        } catch (final RestClientException exp) {
            log.error("Failed to successfully detect language");
        }
    }

}
