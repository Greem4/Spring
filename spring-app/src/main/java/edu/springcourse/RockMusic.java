package edu.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}

