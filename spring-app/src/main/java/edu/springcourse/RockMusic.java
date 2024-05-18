package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    List<String> listSong = new ArrayList<>();

    {
        listSong.add("RockMusic №1");
        listSong.add("RockMusic №2");
        listSong.add("RockMusic №3");
    }
    @Override
    public List<String> getSong() {
        return listSong;
    }
}
