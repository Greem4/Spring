package edu.springcourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private final Music rockMusic;
    private final Music classicalMusic;
    private final Random random = new Random();

    public MusicPlayer(@Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("classicalMusic") Music classicalMusic) {
        this.rockMusic = rockMusic;
        this.classicalMusic = classicalMusic;
    }

    public String playMusic() {
        GenreSong songGenre = GenreSong.values()[random.nextInt(GenreSong.values().length)];

        if (songGenre == GenreSong.ROCK) {
            return "Playing: " +  rockMusic.getSong();
        } else {
            return "Playing: " +  classicalMusic.getSong();
        }
    }
}
