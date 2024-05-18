package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {
    private List<String> list = new ArrayList<>();

    {
        list.add("ClassicalMusic №1");
        list.add("ClassicalMusic №2");
        list.add("ClassicalMusic №3");
    }

    @Override
    public List<String> getSong() {
        return list;
    }
}
