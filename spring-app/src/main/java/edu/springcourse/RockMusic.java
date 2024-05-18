package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music {
    Random random = new Random();
    private List<String> list = new ArrayList<>();

    public RockMusic() {
        addSong();
    }

    public void addSong() {
        list.add("rock music №1");
        list.add("rock music №2");
        list.add("rock music №3");
    }

    @Override
    public String getSong() {
        return list.get(random.nextInt(list.size()));
    }
}
