package com.t11g02.Sidescroller.model;

public class Score {

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void increase(int value) {
        score += value;
    }
}
