package edu.spring.firstsecurityapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AuthenticationDTO {

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной")
    private String username;

    private String password;

    public @NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной") String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

