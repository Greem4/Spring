package edu.spring.translaitor;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final String API_URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";
    private final String folderId;
    private final String targetLanguageCode;
    private final String authToken;

    private Config(String authToken, String folderId, String targetLanguageCode) {
        this.authToken = authToken;
        this.folderId = folderId;
        this.targetLanguageCode = targetLanguageCode;
    }

    public static Config load() {
        Dotenv dotenv = Dotenv.load();
        String authToken = dotenv.get("YANDEX_API_TOKEN");
        String folderId = dotenv.get("YANDEX_FOLDER_ID");
        String targetLanguageCode = dotenv.get("TARGET_LANGUAGE_CODE", "en");
        return new Config(authToken, folderId, targetLanguageCode);
    }

    public String getApiUrl() {
        return API_URL;
    }

    public String getFolderId() {
        return folderId;
    }

    public String getTargetLanguageCode() {
        return targetLanguageCode;
    }

    public String getAuthToken() {
        return authToken;
    }
}

