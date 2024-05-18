package edu.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    private final Random random = new Random();

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
        GenreSong songGenre = GenreSong.values()[random.nextInt(GenreSong.values().length)];

        int randomNum = random.nextInt(3);

        if (songGenre == GenreSong.ROCK) {
            return "Playing: " + rockMusic.getSong().get(randomNum);
        } else {
            return "Playing: " + classicalMusic.getSong().get(randomNum);
        }
    }
}
