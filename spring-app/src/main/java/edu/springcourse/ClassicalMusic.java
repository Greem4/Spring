package edu.springcourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
