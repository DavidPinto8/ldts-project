package com.t11g02.Sidescroller.model;

public class Score { // Singleton class to manage the game score
    private static Score instance;
    private int score = 0;

    public static Score getInstance() {
        if (instance == null)
            instance = new Score();
        return instance;
    }

    public int getScore() {
        return score;
    }

    public void increase(int value) {
        score += value;
    }

    public void reset() {
        score = 0;
    }
}
