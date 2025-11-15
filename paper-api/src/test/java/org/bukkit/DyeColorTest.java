package org.bukkit;

import org.bukkit.material.Colorable;
import org.bukkit.material.Dye;
import org.bukkit.material.Wool;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.bukkit.support.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DyeColorTest {

    @ParameterizedTest
    @EnumSource(DyeColor.class)
    @SuppressWarnings("deprecation")
    public void getByData(DyeColor dye) {
        byte data = dye.getWoolData();

        DyeColor byData = DyeColor.getByWoolData(data);
        assertThat(byData, is(dye));
    }

    @ParameterizedTest
    @EnumSource(DyeColor.class)
    public void getByWoolData(DyeColor dye) {
        byte data = dye.getWoolData();

        DyeColor byData = DyeColor.getByWoolData(data);
        assertThat(byData, is(dye));
    }

    @ParameterizedTest
    @EnumSource(DyeColor.class)
    public void getByDyeData(DyeColor dye) {
        byte data = dye.getDyeData();

        DyeColor byData = DyeColor.getByDyeData(data);
        assertThat(byData, is(dye));
    }

    @ParameterizedTest
    @EnumSource(DyeColor.class)
    public void getDyeDyeColor(DyeColor dye) {
        testColorable(new Dye(Material.LEGACY_INK_SACK, dye.getDyeData()), dye);
        testColorable(new Dye(dye), dye);
    }

    @ParameterizedTest
    @EnumSource(DyeColor.class)
    public void getWoolDyeColor(DyeColor dye) {
        testColorable(new Wool(Material.LEGACY_WOOL, dye.getWoolData()), dye);
    }

    private void testColorable(final Colorable colorable, DyeColor dye) {
        assertThat(colorable.getColor(), is(dye));
    }
}
