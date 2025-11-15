package org.bukkit;

import org.junit.jupiter.api.Test;

import static org.bukkit.support.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DifficultyTest {
    @Test
    public void getByValue() {
        for (Difficulty difficulty : Difficulty.values()) {
            assertThat(Difficulty.getByValue(difficulty.getValue()), is(difficulty));
        }
    }
}
