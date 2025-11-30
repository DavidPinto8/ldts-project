package com.aor.hero.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterPoolTest {
    private MonsterPool pool;

    @BeforeEach
    void setUp() {
        pool = new MonsterPool(10);
    }

    @Test
    void newMonster() {
        pool.getNewMonsterAt(5,5);
        Assertions.assertEquals(1, pool.getInUse().size());
    }

    @Test
    void freeMonster() {
        pool.getNewMonsterAt(5,5);
        pool.addToRemovalBuffer(pool.getInUse().getFirst());
        pool.clearBuffer();
        Assertions.assertEquals(0, pool.getInUse().size());
    }
}
