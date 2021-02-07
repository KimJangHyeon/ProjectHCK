package com.hack.hck.meili.Index.Word;

import com.hack.hck.meili.Index.Genre;

public class Word {
    private String word;
    private Genre genre;
    private int moving;

    public int getMoving() {
        return moving;
    }

    public void setMoving(int moving) {
        this.moving = moving;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Word() {
    }
    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
