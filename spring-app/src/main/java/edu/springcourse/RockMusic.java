package edu.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    private List<String> list = new ArrayList<>();

    {
        list.add("rock music №1");
        list.add("rock music №2");
        list.add("rock music №3");
    }

    @Override
    public List<String> getSong() {
        return list;
    }
}
