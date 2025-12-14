package com.t11g02.Sidescroller.model;

public class Score {
    private int value;

    public void add(int points) {
        value += points;
    }

    public int getValue() {
        return value;
    }
}
