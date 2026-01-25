package io.github.grassproject.petal.bootstrap;

import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;
import net.fabricmc.loader.impl.launch.FabricLauncher;
import net.fabricmc.loader.impl.util.Arguments;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PetalBridgeBootstrap extends MinecraftGameProvider {
    private Path modFile;

    @Override
    public void initialize(FabricLauncher launcher) {
        System.out.println("\u001B[31mFarbicProvider initialize");
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
        System.setProperty("log4j.jul.LoggerAdapter", "io.izzel.arclight.boot.log.ArclightLoggerAdapter");
        System.setProperty("log4j.configurationFile", "arclight-log4j2.xml");
        try {
            this.modFile = this.extract();
            launcher.addToClassPath(modFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (var lib : System.getProperty("petal.fabric.classpath").split(File.pathSeparator)) {
            launcher.addToClassPath(Paths.get(lib));
        }
        super.initialize(launcher);
    }

    @Override
    public Arguments getArguments() {
        Arguments arguments = super.getArguments();
        String old = arguments.get(Arguments.ADD_MODS);
        var builtinMods = System.getProperty("arclight.fabric.builtinMods");
        var path = this.modFile.toString() + File.pathSeparator + builtinMods;
        if (old != null) {
            path = old + File.pathSeparator + path;
        }
        arguments.put(Arguments.ADD_MODS, path);
        return arguments;
    }

    private Path extract() throws Exception {
        String version = "1.0.0";
        System.setProperty("petal.version", version);
        var path = getClass().getModule().getResourceAsStream("/common.jar");
        var dir = Paths.get(".arclight", "mod_file");
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        var mod = dir.resolve(version + ".jar");
        if (!Files.exists(mod) || Boolean.getBoolean("arclight.alwaysExtract")) {
            try (var files = Files.list(dir)) {
                for (Path old : files.toList()) {
                    Files.delete(old);
                }
                Files.copy(path, mod);
            }
        }
        return mod;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
