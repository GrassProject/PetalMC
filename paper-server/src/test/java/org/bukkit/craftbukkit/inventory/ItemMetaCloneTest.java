package org.bukkit.craftbukkit.inventory;

import java.lang.reflect.Method;
import org.bukkit.Material;
import org.bukkit.support.environment.AllFeatures;
import org.junit.jupiter.api.Test;

import static org.bukkit.support.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AllFeatures
public class ItemMetaCloneTest {

    @Test
    public void testClone() throws Throwable {
        for (Material material : ItemStackTest.COMPOUND_MATERIALS) {
            Class<?> clazz = CraftItemFactory.instance().getItemMeta(material).getClass();

            Method clone = clazz.getDeclaredMethod("clone");
            assertNotNull(clone, "Class " + clazz + " does not override clone()");
            assertThat(clone.getReturnType(), is(equalTo(clazz)), "Class " + clazz + " clone return type does not match");
        }
    }
}
