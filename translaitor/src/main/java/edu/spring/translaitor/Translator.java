package edu.spring.translaitor;

import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Translator {
    public static void main(String[] args) {
        Config config = Config.load();
        if (config.getAuthToken() == null || config.getAuthToken().isEmpty() || config.getFolderId() == null || config.getFolderId().isEmpty()) {
            System.err.println("Error: YANDEX_API_TOKEN or YANDEX_FOLDER_ID environment variable is not set.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение на русском языке:");
        String sentenceToTranslate = scanner.nextLine();

        TranslationService translationService = new TranslationService(config);
        CountDownLatch latch = new CountDownLatch(1);

        translationService.translate(sentenceToTranslate)
                .doOnError(e -> {
                    if (e instanceof WebClientResponseException webClientResponseException) {
                        System.err.println("HTTP Status Code: " + webClientResponseException.getStatusCode());
                        System.err.println("HTTP Response Body: " + webClientResponseException.getResponseBodyAsString());
                    } else {
                        System.err.println("Error: " + e.getMessage());
                    }
                    latch.countDown();
                })
                .subscribe(yandexResponse -> {
                    System.out.println("Перевод: " + yandexResponse.getTranslations().getFirst().getText());
                    latch.countDown();
                });

        try {
            latch.await(); // Ждем завершения асинхронного запроса
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
        }
}
