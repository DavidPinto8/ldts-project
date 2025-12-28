package com.t11g02.Sidescroller.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    void increase() {
        Score score = Score.getInstance();
        score.reset();
        Assertions.assertEquals(0, score.getScore());
        score.increase(10);
        Assertions.assertEquals(10, score.getScore());
        score.increase(5);
        Assertions.assertEquals(15, score.getScore());
    }

    @Test
    void reset() {
        Score score = Score.getInstance();
        score.reset();
        Assertions.assertEquals(0, score.getScore());
        score.increase(20);
        Assertions.assertEquals(20, score.getScore());
        score.reset();
        Assertions.assertEquals(0, score.getScore());
    }
}
