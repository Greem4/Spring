package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    List<String> listSong = new ArrayList<>();

    {
        listSong.add("ClassicalMusic №1");
        listSong.add("ClassicalMusic №2");
        listSong.add("ClassicalMusic №3");
    }

    @Override
    public List<String> getSong() {
        return listSong;
    }
}
