package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {
    Random rand = new Random();
    private List<String> list = new ArrayList<>();

    public ClassicalMusic() {
        addSong();
    }

    private void addSong() {
        list.add("ClassicalMusic №1");
        list.add("ClassicalMusic №2");
        list.add("ClassicalMusic №3");
    }

    @Override
    public String getSong() {
        return list.get(rand.nextInt(list.size()));
    }
}
