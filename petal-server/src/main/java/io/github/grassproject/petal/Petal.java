package io.github.grassproject.petal;

import io.github.grassproject.petal.bridge.PetalBridge;
import net.minecraft.server.MinecraftServer;
import org.bukkit.craftbukkit.CraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Petal {
    private static final Logger LOGGER = LoggerFactory.getLogger("Petal");

    public static String ServerName = "Petal";
    public static String version = "1.21.8";

    public MinecraftServer getServer() {
        return PetalBridge.getMinecraftServer();
    }

    public CraftServer getCraftServer() {
        return PetalBridge.getCraftServer();
    }

    public static boolean isReady() {
        return PetalBridge.isPaperLoaded() && PetalBridge.isFabricLoaded();
    }

    public static void init() {
        LOGGER.info("init");
        List.of(
            "\u001B[31m██████╗ ███████╗████████╗ █████╗ ██╗     ███╗   ███╗ ██████╗\u001B[0m",
            "\u001B[31m██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║     ████╗ ████║██╔════╝",
            "\u001B[31m██████╔╝█████╗     ██║   ███████║██║     ██╔████╔██║██║     ",
            "\u001B[31m██╔═══╝ ██╔══╝     ██║   ██╔══██║██║     ██║╚██╔╝██║██║     ",
            "\u001B[31m██║     ███████╗   ██║   ██║  ██║███████╗██║ ╚═╝ ██║╚██████╗",
            "\u001B[31m╚═╝     ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝\u001B[0m",
            "                                       Made by. GrassProject"
        ).forEach(LOGGER::info);
    }
}
