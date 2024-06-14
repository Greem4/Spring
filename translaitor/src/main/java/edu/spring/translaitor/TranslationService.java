package edu.spring.translaitor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

public class TranslationService {
    private final WebClient webClient;
    private final Config config;

    public TranslationService(Config config) {
        this.config = config;
        this.webClient = WebClient.builder()
                .baseUrl(config.getApiUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + config.getAuthToken())
                .build();
    }

    public Mono<YandexResponse> translate(String sentenceToTranslate) {
        Map<String, Object> jsonData = Map.of(
                "folderId", config.getFolderId(),
                "targetLanguageCode", config.getTargetLanguageCode(),
                "texts","[" + sentenceToTranslate + "]"
        );

        return webClient.post()
                .bodyValue(jsonData)
                .retrieve()
                .bodyToMono(YandexResponse.class);
    }
}

