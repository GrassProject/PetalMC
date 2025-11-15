package org.bukkit.craftbukkit.block;

import java.lang.reflect.Field;
import org.bukkit.block.BlockType;
import org.bukkit.support.environment.AllFeatures;
import org.junit.jupiter.api.Test;

import static org.bukkit.support.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@AllFeatures
public class BlockTypeTest {

    // Ensures all BlockType constants have the correct generics
    @Test
    public void testBlockDataClasses() throws Exception {
        for (Field f : BlockType.class.getDeclaredFields()) {
            BlockType type = (BlockType) f.get(null);

            Class<?> expected = type.getBlockDataClass();
            Class<?> actual = type.typed().createBlockData().getClass().getInterfaces()[0];
            assertThat(actual, is(expected));
        }
    }
}
