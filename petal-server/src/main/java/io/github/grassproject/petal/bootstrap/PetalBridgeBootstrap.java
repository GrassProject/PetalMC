package io.github.grassproject.petal.bootstrap;

import net.fabricmc.loader.impl.game.GameProvider;
import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;
import net.fabricmc.loader.impl.game.patch.GameTransformer;
import net.fabricmc.loader.impl.launch.FabricLauncher;
import net.fabricmc.loader.impl.util.Arguments;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PetalBridgeBootstrap implements GameProvider {

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean locateGame(FabricLauncher launcher, String[] args) {
        return true;
    }

    @Override
    public void initialize(FabricLauncher launcher) {
        System.out.println("Petal GameProvider initialize");
    }

    @Override
    public GameTransformer getEntrypointTransformer() {
        return null;
    }

    @Override
    public void unlockClassPath(FabricLauncher launcher) {

    }

    @Override
    public void launch(ClassLoader loader) {

    }

    @Override
    public String getGameId() {
        return "petalmc";
    }

    @Override
    public String getGameName() {
        return "PetalMC";
    }

    @Override
    public String getRawGameVersion() {
        return "1.21.8";
    }

    @Override
    public String getNormalizedGameVersion() {
        return getRawGameVersion();
    }

    @Override
    public Collection<BuiltinMod> getBuiltinMods() {
        return List.of();
    }

    @Override
    public String getEntrypoint() {
        return "org.bukkit.craftbukkit.Main";
    }

    @Override
    public Path getLaunchDirectory() {
        return Paths.get(".");
    }

    @Override
    public boolean requiresUrlClassLoader() {
        return false;
    }

    @Override
    public Set<BuiltinTransform> getBuiltinTransforms(String className) {
        return Set.of();
    }

    @Override
    public Arguments getArguments() {
        return new Arguments();
    }


    @Override
    public String[] getLaunchArguments(boolean sanitize) {
        return new String[0];
    }
}
